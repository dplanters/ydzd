package com.gndc.core.controller.app.account;

import com.gndc.common.api.HjException;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.api.ResultCode;
import com.gndc.common.enums.common.LoginDeviceType;
import com.gndc.common.enums.user.UserEventsType;
import com.gndc.common.utils.*;
import com.gndc.core.api.app.user.account.PUserLoginRequest;
import com.gndc.core.api.app.user.account.PUserLoginResponse;
import com.gndc.core.model.User;
import com.gndc.core.model.UserEvent;
import com.gndc.core.service.sys.IUserCacheService;
import com.gndc.core.service.user.UserEventService;
import com.gndc.core.service.user.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 客户端用户账号相关
 */
@RestController
@RequestMapping("/user/account")
public class PAccountController {

    private static final Logger logger = LoggerFactory.getLogger(PAccountController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserEventService userEventService;

    @Autowired
    private IUserCacheService userCacheService;

    @PostMapping("/login")
    public ResponseMessage<PUserLoginResponse> productList(@Validated @RequestBody PUserLoginRequest request) {


        ResponseMessage<PUserLoginResponse> response = new ResponseMessage<>();


        // 手机号
        String phone = request.getPhone();

        // 密码
        String password = request.getPassword();

        // 设备token
        String imei = request.getImei();

        // 手机终端品牌型号
        String termType = request.getTermType();

        User userinfo = null;

        if (StringUtils.isBlank(request.getHeader().getDeviceType())) {
            response.createError(ResultCode.DEVICETYPE_ISNULL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }

        if (StringUtils.isBlank(phone)) {
            response.createError(ResultCode.USER_PHONE_ISNULL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }

        if (!PhoneUtil.checkPhone(phone)) {
            throw new HjException(ResultCode.PHONE_WRONG);
        }

        User user4Search = new User();
        user4Search.setPhone(phone);
        User user = userService.selectOne(user4Search);
        byte deviceType = Byte.parseByte(request.getHeader().getDeviceType());


        if ((deviceType == LoginDeviceType.ANDROID.getCode() || deviceType == LoginDeviceType.IOS.getCode())) {
            if (StringUtils.isBlank(imei)) {
                response.createError(ResultCode.IMEI_TOKEN_ISNULL);
                logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
                return response;
            }

            if (StringUtils.isBlank(termType)) {
                response.createError(ResultCode.TERM_TYPE_ISNULL);
                logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
                return response;
            }
            if (StringUtils.isBlank(password)) {
                response.createError(ResultCode.PASSWORD_ISNULL);
                logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
                return response;
            }

            if (userinfo == null) {
                response.createError(ResultCode.USER_NOT_EXISTS);
                logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
                return response;
            }

            String passwordDec = PwdUtil.decryptRSA(password);
            PwdUtil.validate(passwordDec);
            String pwdMd5 = PwdUtil.getPassword(passwordDec, userinfo.getPasswordSign());

            if (!pwdMd5.equals(userinfo.getPassword())) {
                response.createError(ResultCode.USER_NAME_PASSWORD_ERROR);
                logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
                return response;
            }

        }

        Date now = DateUtil.getCountyTime();


        // 用户登录事件记录
        UserEvent userEvents = new UserEvent();
        userEvents.setUserId(userinfo.getId());
        userEvents.setEventTime(now);
        userEvents.setIpAddress(request.getHeader().getIp());
        userEvents.setEventType(UserEventsType.LOGIN.getCode());
        userEvents.setRemark("密码登录");
        userEventService.insertSelective(userEvents);


        User user4Update = new User();

        user4Update.setId(userinfo.getId());

        user4Update.setId(userinfo.getId());
        user4Update.setLastLoginTime(now);
        user4Update.setLastLoginDevice(deviceType);
        user4Update.setLastLoginIp(request.getHeader().getIp());
        userService.updateByPrimaryKeySelective(user4Update);

        PUserLoginResponse pUserLoginResponse = new PUserLoginResponse();
        pUserLoginResponse.setPhone(phone);
        String sessionId = Utils.getSessionId();
        pUserLoginResponse.setSessionId(sessionId);

        userCacheService.setUser(sessionId, userinfo);

        response.setData(pUserLoginResponse);

        logger.info(String.format("应答:%s", JsonUtil.toJSONString(response)));

        return response;

    }


}
