package com.gndc.core.controller.app.account;

import com.gndc.common.constant.CacheConstant;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.common.UserDeviceEnum;
import com.gndc.common.enums.user.UserEventsTypeEnum;
import com.gndc.common.enums.user.UserStatusEnum;
import com.gndc.common.utils.*;
import com.gndc.core.api.app.platform.Sms10MinuteCount;
import com.gndc.core.api.app.platform.SmsInfo;
import com.gndc.core.api.app.user.account.*;
import com.gndc.core.api.common.CommonResponse;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.model.User;
import com.gndc.core.model.UserEvent;
import com.gndc.core.service.sms.SmsLogService;
import com.gndc.core.service.user.UserEventService;
import com.gndc.core.service.user.UserService;
import org.apache.commons.lang.StringUtils;
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
import java.util.concurrent.TimeUnit;

/**
 * 客户端用户账号相关
 */
@RestController
@RequestMapping("/app/user/account")
public class PAccountController {

    private static final Logger logger = LoggerFactory.getLogger(PAccountController.class);

    private static final String P_SMS_USER_LOGIN = "P_SMS_USER_LOGIN";
    private static final String P_SMS_USER_FORGET_PWD = "P_SMS_USER_FORGET_PWD";

    @Autowired
    private UserService userService;

    @Autowired
    private UserEventService userEventService;

    @Autowired
    private SmsLogService smsLogService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 密码登录
     *
     * @param request
     * @return
     */
    @PostMapping("/loginByPwd")
    public ResponseMessage<PUserLoginResponse> login(@Validated @RequestBody PUserPwdLoginRequest request) {
        ResponseMessage<PUserLoginResponse> response = new ResponseMessage<>();
        // 手机号
        String phone = request.getPhone();
        // 密码
        String password = request.getPassword();
        // 设备token
        String imei = request.getImei();
        // 手机终端品牌型号
        String termType = request.getTermType();

        User userInfo = null;

        if (StringUtils.isBlank(request.getHeader().getDeviceType())) {
            response.createError(ResultCode.DEVICETYPE_ISNULL);
            logger.warn(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }

        userInfo = userService.selectOneByProperty("phone", phone);
        byte deviceType = Byte.parseByte(request.getHeader().getDeviceType());


        if ((deviceType == UserDeviceEnum.ANDROID.getCode() || deviceType == UserDeviceEnum.IOS.getCode())) {
            if (StringUtils.isBlank(imei)) {
                response.createError(ResultCode.IMEI_TOKEN_ISNULL);
                logger.warn(String.format("应答:%s", JsonUtil.toJSONString(response)));
                return response;
            }

            if (StringUtils.isBlank(termType)) {
                response.createError(ResultCode.TERM_TYPE_ISNULL);
                logger.warn(String.format("应答:%s", JsonUtil.toJSONString(response)));
                return response;
            }

            if (userInfo == null) {
                response.createError(ResultCode.USER_NOT_EXISTS);
                logger.warn(String.format("应答:%s", JsonUtil.toJSONString(response)));
                return response;
            }

            String passwordDec = PwdUtil.decryptRSA(password);
            PwdUtil.validate(passwordDec);
            String pwdMd5 = PwdUtil.getPassword(passwordDec, userInfo.getPasswordSign());

            if (!pwdMd5.equals(userInfo.getPassword())) {
                response.createError(ResultCode.USER_NAME_PASSWORD_ERROR);
                logger.warn(String.format("应答:%s", JsonUtil.toJSONString(response)));
                return response;
            }

        }

        String sessionId = doLogin(userInfo.getId(), request.getHeader().getIp(), "密码登录", deviceType);
        PUserLoginResponse userLoginResponse = new PUserLoginResponse();
        userLoginResponse.setPhone(phone);
        userLoginResponse.setSessionId(sessionId);
        response.setData(userLoginResponse);

        return response;
    }

    /**
     * 验证码登录
     *
     * @param request
     * @return
     */
    @PostMapping("/loginByValCode")
    public ResponseMessage<PUserLoginResponse> login(@Validated @RequestBody PUserValCodeLoginRequest request) {
        ResponseMessage<PUserLoginResponse> response = new ResponseMessage<>();
        String phone = request.getPhone();
        String imei = request.getImei();
        String termType = request.getTermType();
        // 验证码验证
        String valCode = request.getValCode();
        String regChannel = request.getRegChannel();

        String appName = request.getAppName();
        String appPackage = request.getAppPackage();

        if (StringUtils.isBlank(request.getHeader().getDeviceType())) {
            response.createError(ResultCode.DEVICETYPE_ISNULL);
            logger.warn(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }

        byte deviceType = Byte.parseByte(request.getHeader().getDeviceType());

        if ((deviceType == UserDeviceEnum.ANDROID.getCode() || deviceType == UserDeviceEnum.IOS.getCode())) {
            if (StringUtils.isBlank(imei)) {
                response.createError(ResultCode.IMEI_TOKEN_ISNULL);
                logger.warn(String.format("应答:%s", JsonUtil.toJSONString(response)));
                return response;
            }

            if (StringUtils.isBlank(termType)) {
                response.createError(ResultCode.TERM_TYPE_ISNULL);
                logger.warn(String.format("应答:%s", JsonUtil.toJSONString(response)));
                return response;
            }
        }

        String key = P_SMS_USER_LOGIN + phone;

        String sms10MinuteCountStr = (String) redisTemplate.opsForValue().get(CacheConstant.KEY_USER_SMS_10_PREFIX + key);
        String smsInfoStr = (String) redisTemplate.opsForValue().get(CacheConstant.KEY_USER_SMS_15M_PREFIX + key);

        Sms10MinuteCount sms10MinuteCount = JsonUtil.getObject(sms10MinuteCountStr, Sms10MinuteCount.class);
        SmsInfo smsInfo = JsonUtil.getObject(smsInfoStr, SmsInfo.class);

        if (!smsLogService.validateSms(smsInfo, sms10MinuteCount, key, valCode, response)) {
            return response;
        }

        Date now = DateUtil.getCountyTime();

        // 验证手机号是否已经注册
        User user = userService.selectOneByProperty("phone", phone);

        if (null == user) {
            Date date = DateUtil.getCountyTime();
            user.setPhone(phone);
            user.setRegDevice(deviceType);
            user.setImei(imei);
            user.setStatus(UserStatusEnum.INFO_UNFILLED.getCode());
            user.setRegTime(date);
            user.setLastLoginTime(date);
            user.setRegChannel(regChannel);
            user.setRegTermType(termType);
            user.setRegDevicetoken(imei);
            user.setLastLoginTime(now);
            user.setLastLoginIp(request.getHeader().getIp());
            user.setLastLoginDevice(deviceType);
            user.setLastLoginDevicetoken(termType);
            user.setAppName(appName);
            user.setAppPackage(appPackage);
            userService.insertSelective(user);
        }

        String sessionId = doLogin(user.getId(), request.getHeader().getIp(), "验证码登录", deviceType);
        PUserLoginResponse userLoginResponse = new PUserLoginResponse();
        userLoginResponse.setPhone(phone);
        userLoginResponse.setSessionId(sessionId);
        // 判断有没有密码
        if (StringUtils.isBlank(user.getPassword())) {
            userLoginResponse.setHasPassword(0);
        } else {
            userLoginResponse.setHasPassword(1);
        }
        response.setData(userLoginResponse);
        return response;
    }

    private String doLogin(Integer userId, String ip, String remark, Byte deviceType) {

        Date now = DateUtil.getCountyTime();
        // 用户登录事件记录
        UserEvent userEvents = new UserEvent();
        userEvents.setUserId(userId);
        userEvents.setEventTime(now);
        userEvents.setIpAddress(ip);
        userEvents.setEventType(UserEventsTypeEnum.LOGIN.getCode());
        userEvents.setRemark(remark);
        userEventService.insertSelective(userEvents);

        User user4update = new User();
        user4update.setId(userId);
        user4update.setLastLoginTime(now);
        user4update.setLastLoginDevice(deviceType);
        user4update.setLastLoginIp(ip);
        userService.updateByPrimaryKeySelective(user4update);

        String sessionId = Utils.getSessionId();
        User userInfo = new User();
        userInfo.setId(userId);
        redisTemplate.opsForValue().set(CacheConstant.KEY_USER_LOGIN_PREFIX + sessionId, userInfo,
                CacheConstant.EXPIRE_USER_LOGIN, TimeUnit.SECONDS);

        // 打开app统计
        userEventService.statisticsUserOpenApp(userId, ip);
        return sessionId;
    }

    /**
     * 设置密码
     *
     * @param request
     * @return
     */
    @PostMapping("/editPassword")
    public ResponseMessage<CommonResponse> editPassword(@Validated @RequestBody PUserEditPasswordRequest request) {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        String sessionId = request.getHeader().getSessionId();
        String userInfoStr = (String) redisTemplate.opsForValue().get(CacheConstant.KEY_USER_LOGIN_PREFIX + sessionId);
        User user = JsonUtil.getObject(userInfoStr, User.class);
        if (user == null) {
            response.createError(ResultCode.SESSIONID_ISNULL);
            logger.warn(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
        String password = request.getPassword();
        String newPassword = request.getNewPassword();
        String confirmPassword = request.getConfirmPassword();

        if (StringUtils.isBlank(newPassword) || StringUtils.isBlank(confirmPassword)) {
            response.createError(ResultCode.PARAM_MISSING);
            logger.warn(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }

        try {
            if (StringUtils.isNotBlank(password)) {
                password = PwdUtil.decryptRSA(password);
            }

            newPassword = PwdUtil.decryptRSA(newPassword);

            confirmPassword = PwdUtil.decryptRSA(confirmPassword);

        } catch (Exception e) {
            response.createError(ResultCode.PARAMETER_ERROR);
            logger.warn(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }

        PwdUtil.validate(newPassword);
        // 从数据获取用户信息
        User userInfo = userService.selectByPrimaryKey(user.getId());
        if (StringUtils.isNotBlank(userInfo.getPassword()) && StringUtils.isBlank(password)) {
            response.createError(ResultCode.PASSWORD_ISNULL);
            logger.warn(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }

        String passwordSign = userInfo.getPasswordSign();

        if (StringUtils.isNotBlank(userInfo.getPassword())) {

            if (!userInfo.getPassword().equals(PwdUtil.getPassword(password, userInfo.getPasswordSign()))) {
                response.createError(ResultCode.OLD_PASSWORD_ERROR);
                logger.warn(String.format("应答:%s", JsonUtil.toJSONString(response)));
                return response;
            }

        } else {
            if (!newPassword.equals(confirmPassword)) {
                response.createError(ResultCode.CONFIRM_PASSWORD_ERROR);
                logger.warn(String.format("应答:%s", JsonUtil.toJSONString(response)));
                return response;
            }
        }

        passwordSign = String.valueOf(Utils.getRandom(6));
        userInfo.setPasswordSign(passwordSign);
        userInfo.setPassword(PwdUtil.getPassword(newPassword, passwordSign));
        int flag = userService.updatePassword(userInfo);
        if (flag <= 0) {
            response.createError(ResultCode.RECORD_UPDATE_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
        return response;
    }

    /**
     * 忘记密码
     *
     * @param request
     * @return
     */
    @PostMapping("/forgetPassword")
    public ResponseMessage<CommonResponse> forgetPassword(@Validated @RequestBody PUserForgetPasswordRequest request) {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        String phone = request.getPhone();
        String valCode = request.getValCode();
        String password = request.getPassword();
        String confirmPassword = request.getConfirmPassword();

        String key = P_SMS_USER_FORGET_PWD + phone;

        String sms10MinuteCountStr = (String) redisTemplate.opsForValue().get(CacheConstant.KEY_USER_SMS_10_PREFIX + key);
        String smsInfoStr = (String) redisTemplate.opsForValue().get(CacheConstant.KEY_USER_SMS_15M_PREFIX + key);

        Sms10MinuteCount sms10MinuteCount = JsonUtil.getObject(sms10MinuteCountStr, Sms10MinuteCount.class);
        SmsInfo smsInfo = JsonUtil.getObject(smsInfoStr, SmsInfo.class);

        if (!smsLogService.validateSms(smsInfo, sms10MinuteCount, key, valCode, response)) {
            return response;
        }

        // 根据手机号查询出当前用户
        User user = userService.selectOneByProperty("phone", phone);
        if (null == user) {
            response.createError(ResultCode.USER_NOT_EXISTS);
            logger.warn(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }

        String passwordSign = String.valueOf(Utils.getRandom(6));
        user.setPasswordSign(passwordSign);

        password = PwdUtil.decryptRSA(password);
        confirmPassword = PwdUtil.decryptRSA(confirmPassword);
        if (!password.equals(confirmPassword)) {
            response.createError(ResultCode.CONFIRM_PASSWORD_ERROR);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }

        user.setPassword(PwdUtil.getPassword(password, passwordSign));
        int flag = userService.updatePassword(user);
        if (flag <= 0) {
            response.createError(ResultCode.RECORD_UPDATE_FAIL);
            logger.error(String.format("应答:%s", JsonUtil.toJSONString(response)));
            return response;
        }
        logger.info(String.format("应答:%s", JsonUtil.toJSONString(response)));
        return response;
    }
}
