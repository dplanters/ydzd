package com.gndc.core.controller.admin.account;

import cn.hutool.core.util.StrUtil;
import com.gndc.common.exception.HjException;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.constant.Constant;
import com.gndc.common.enums.admin.AdminType;
import com.gndc.common.enums.common.DelType;
import com.gndc.common.utils.Utils;
import com.gndc.core.api.admin.account.AOLoginRequest;
import com.gndc.core.api.admin.account.AOLoginResponse;
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

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/account")
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
    private RedisTemplate<String, Serializable> redisTemplate;

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
            throw new HjException(ResultCode.USER_NOT_EXISTS, msg);
        }

        if (admin.getStatus().equals(DelType.IS_DEL.getCode())) {
            String template = "用户名 {} 已停用";
            String msg = StrUtil.format(template, loginName);
            logger.warn(msg);
            throw new HjException(ResultCode.USER_DISABLED, msg);
        }
        //密码校验
        if (!accountService.passwordCheck(admin, password)) {
            logger.warn(ResultCode.USER_NAME_PASSWORD_ERROR.getI18NContent());
            throw new HjException(ResultCode.USER_NAME_PASSWORD_ERROR);
        }
        admin.setLastLoginIp(request.getHeader().getIp());
        admin.setLastLoginTime(new Date());

        //更新登录信息
        adminService.updateByPrimaryKeySelective(admin);
        //分配session
        String sessionId = Utils.getSessionId();
        //获取权限树
        Byte level = admin.getLevel();
        AdminType adminType = AdminType.fetch(level);
        List<Right> rights = null;
        List<Integer> rightIds = null;
        switch (adminType) {
            case SUPER_ADMIN:
                //获取所有权限id集合
                rightIds = roleRightService.getRightIds(null);
                rights = rightService.rightsTree((byte)1, (byte)1, 0, rightIds);
                admin.setRights(rights);
                break;
            case ORDINARY_ADMIN:
                Role role = roleService.selectByPrimaryKey(admin.getRoleId());
                rightIds = roleRightService.getRightIds(role.getId());
                rights = rightService.rightsTree((byte)1, (byte)1, 0, rightIds);
                admin.setRights(rights);
                break;
            default:
                String template = "{} 管理员账号，不允许登录";
                String msg = StrUtil.format(template, loginName);
                logger.warn(msg);
                throw new HjException(ResultCode.ERROR, msg);
        }
        aoLoginResponse.setAdmin(admin);
        aoLoginResponse.setSessionId(sessionId);
        //缓存半小时
        redisTemplate.opsForValue().set(Constant.ADMIN_LOGIN_PREFIX + sessionId, aoLoginResponse, 30, TimeUnit.MINUTES);

        response.setData(aoLoginResponse);
        return response;
    }
}