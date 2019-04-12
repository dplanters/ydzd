package com.gndc.core.controller.partner.account;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.dto.APAdminLoginInfoDTO;
import com.gndc.common.dto.RightInfoDTO;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.common.PlatformEnum;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.exception.HjException;
import com.gndc.common.utils.PwdUtil;
import com.gndc.core.api.partner.account.APLoginRequest;
import com.gndc.core.api.partner.account.APLoginResponse;
import com.gndc.core.api.partner.sys.APAdminResetPwdRequest;
import com.gndc.core.mappers.APAdminLoginInfoDTOMapping;
import com.gndc.core.model.Admin;
import com.gndc.core.model.Right;
import com.gndc.core.model.Role;
import com.gndc.core.service.account.AccountService;
import com.gndc.core.service.account.AdminService;
import com.gndc.core.service.sys.RightService;
import com.gndc.core.service.sys.RoleRightService;
import com.gndc.core.service.sys.RoleService;
import com.gndc.core.util.RightConvertUtil;
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
@RequestMapping("/partner/account")
public class APAccountController {

    private static final Logger logger = LoggerFactory.getLogger(APAccountController.class);

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
     * 登录模块
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ResponseMessage<APLoginResponse> login(@Validated @RequestBody APLoginRequest request) {
        ResponseMessage<APLoginResponse> response = new ResponseMessage<>();

        APLoginResponse apLoginResponse = new APLoginResponse();

        //业务校验
        String loginName = request.getLoginName();
        String password = request.getPassword();
        Admin admin = adminService.selectOneByProperty(Admin::getLoginName, loginName);

        if (admin == null) {
            String msg = StrUtil.format("用户名 {} 不存在", loginName);
            logger.warn(msg);
            throw new HjException(ResultCode.USER_NOT_EXISTS);
        }

        if (admin.getStatus().equals(StatusEnum.DELETE.getCode())) {
            String msg = StrUtil.format("用户名 {} 已停用", loginName);
            logger.warn(msg);
            throw new HjException(ResultCode.USER_DISABLED);
        }
        //密码校验
        if (!accountService.passwordCheck(admin, password)) {
            throw new HjException(ResultCode.PASSWORD_ERROR);
        }
        admin.setLastLoginIp(request.getHeader().getIp());
        admin.setLastLoginTime(new Date());

        //更新登录信息
        adminService.updateByPrimaryKeySelective(admin);
        //分配session
        String sessionId = IdUtil.simpleUUID();
        //获取权限树
        List<Right> rights = null;
        List<Integer> rightIds = null;
        //不是商户账号不允许登录
        if (!PlatformEnum.PARTNER.getCode().equals(admin.getPlatform())) {
            logger.warn("{} 不允许登录商户平台", admin.getPlatform());
            throw new HjException(ResultCode.NOT_ALLOW_LOGIN);
        } else {
            Role role = roleService.selectByPrimaryKey(admin.getRoleId());
            rightIds = roleRightService.getRightIds(role.getId());
            rights = rightService.rightsTree((byte)1, PlatformEnum.PARTNER.getCode(), 0, rightIds);
            admin.setRights(CollUtil.isEmpty(rights) ? null : rights.get(0).getChildren());
        }
        APAdminLoginInfoDTO adminInfo = APAdminLoginInfoDTOMapping.INSTANCE.convert(admin);
        List<RightInfoDTO> rightInfoDTOS = RightConvertUtil.convertToRightInfo(rights);
        adminInfo.setRights(CollUtil.isEmpty(rightInfoDTOS) ? null : rightInfoDTOS.get(0).getChildren());
        apLoginResponse.setAdmin(adminInfo);
        apLoginResponse.setSessionId(sessionId);
        //缓存半小时
        redisTemplate.opsForValue().set(CacheConstant.NAMESPACE_PARTNER_LOGIN + sessionId, adminInfo,
                CacheConstant.EXPIRE_PARTNER_LOGIN, TimeUnit.SECONDS);

        response.setData(apLoginResponse);
        return response;
    }

    /**
     * 重置密码
     * @param request
     * @return
     */
    @PostMapping("/resetPwd")
    public ResponseMessage<Boolean> resetPwd(@Validated @RequestBody APAdminResetPwdRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();
        Admin admin = adminService.selectByPrimaryKey(request.getApAdmin().getId());

        //密码校验
        if (!accountService.passwordCheck(admin, request.getOldPassword())) {
            throw new HjException(ResultCode.OLD_PASSWORD_ERROR);
        }

        String passwordDec = PwdUtil.decrypt(request.getPassword());
        String operateSign = RandomUtil.randomString(6);
        String passwordSign = RandomUtil.randomString(6);
        String md5Password = PwdUtil.passwordGenerate(passwordDec, passwordSign);


        admin.setPasswordSign(passwordSign);
        admin.setOperateSign(operateSign);
        admin.setPassword(md5Password);
        admin.setUpdateTime(new Date());

        adminService.updateByPrimaryKeySelective(admin);
        response.setData(true);
        return response;
    }
}
