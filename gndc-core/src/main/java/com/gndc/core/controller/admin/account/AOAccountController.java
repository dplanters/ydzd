package com.gndc.core.controller.admin.account;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.admin.AdminSuperAdminEnum;
import com.gndc.common.enums.common.PlatformEnum;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.exception.HjException;
import com.gndc.core.api.admin.account.AOLoginAdminInfo;
import com.gndc.core.api.admin.account.AOLoginRequest;
import com.gndc.core.api.admin.account.AOLoginResponse;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.mappers.AOLoginAdminInfoMapping;
import com.gndc.core.model.Admin;
import com.gndc.core.model.Right;
import com.gndc.core.model.Role;
import com.gndc.core.service.account.AccountService;
import com.gndc.core.service.account.AdminService;
import com.gndc.core.service.sys.RightService;
import com.gndc.core.service.sys.RoleRightService;
import com.gndc.core.service.sys.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/admin/account")
public class AOAccountController {

    private static final Logger logger = LoggerFactory.getLogger(AOAccountController.class);

    @Autowired
    private AdminService adminService;

    @Autowired
    private RightService rightService;

    @Autowired
    private RoleRightService roleRightService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 管理员登录
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ResponseMessage<AOLoginResponse> login(@Validated @RequestBody AOLoginRequest request) {
        ResponseMessage<AOLoginResponse> response = new ResponseMessage<>();

        AOLoginResponse aoLoginResponse = new AOLoginResponse();

        //业务校验
        String loginName = request.getLoginName();
        String password = request.getPassword();
        Admin admin = adminService.selectOneByProperty("loginName", loginName);

        if (admin == null) {
            String template = "用户名 {} 不存在";
            String msg = StrUtil.format(template, loginName);
            logger.warn(msg);
            throw new HjException(ResultCode.ADMIN_NOT_EXIST, msg);
        }

        if (admin.getStatus().equals(StatusEnum.DELETE.getCode())) {
            String template = "用户名 {} 已停用";
            String msg = StrUtil.format(template, loginName);
            logger.warn(msg);
            throw new HjException(ResultCode.ADMIN_NOT_EXIST, msg);
        }
        //密码校验
        if (!accountService.passwordCheck(admin, password)) {
            logger.warn(ResultCode.PASSWORD_ERROR.getI18NContent());
            throw new HjException(ResultCode.PASSWORD_ERROR);
        }
        admin.setLastLoginIp(request.getHeader().getIp());
        admin.setLastLoginTime(new Date());

        //更新登录信息
        adminService.updateByPrimaryKeySelective(admin);
        //分配session
        String sessionId = IdUtil.simpleUUID();
        //不是运营账号不允许登录
        if (!PlatformEnum.OPERATOR.getCode().equals(admin.getPlatform())) {
            logger.warn("{} 不允许登录运营平台", admin.getPlatform());
            throw new HjException(ResultCode.NOT_ALLOW_LOGIN);
        }

        //获取权限树
        Byte superAdmin = admin.getSuperAdmin();
        AdminSuperAdminEnum superAdminEnum = AdminSuperAdminEnum.fetch(superAdmin);

        List<Right> rights = null;
        List<Integer> rightIds = null;

        switch (superAdminEnum) {
            case SUPER_ADMIN:
                //获取所有权限id集合
                rightIds = rightService.rightIds(PlatformEnum.OPERATOR.getCode());
                rights = rightService.rightsTree((byte)1, PlatformEnum.OPERATOR.getCode(), 0, rightIds);
                admin.setRights(CollUtil.isEmpty(rights) ? null : rights.get(0).getChildren());
                break;
            case ORDINARY_ADMIN:
                Role role = roleService.selectByPrimaryKey(admin.getRoleId());
                rightIds = roleRightService.getRightIds(role.getId());
                rights = rightService.rightsTree((byte)1, PlatformEnum.OPERATOR.getCode(), 0, rightIds);
                admin.setRights(CollUtil.isEmpty(rights) ? null : rights.get(0).getChildren());
                break;
            default:
                String template = "无效的账号类型";
                String msg = StrUtil.format(template, loginName);
                logger.warn(msg);
                throw new HjException(ResultCode.ERROR, msg);
        }
        AOLoginAdminInfo adminInfo = AOLoginAdminInfoMapping.INSTANCE.convert(admin);
        aoLoginResponse.setAdmin(adminInfo);
        aoLoginResponse.setSessionId(sessionId);
        //缓存半小时
        redisTemplate.opsForValue().set(CacheConstant.NAMESPACE_ADMIN_LOGIN + sessionId, adminInfo,
                CacheConstant.EXPIRE_ADMIN_LOGIN, TimeUnit.SECONDS);

        response.setData(aoLoginResponse);
        return response;
    }
}
