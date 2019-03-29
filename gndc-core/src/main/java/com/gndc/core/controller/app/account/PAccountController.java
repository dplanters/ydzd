package com.gndc.core.controller.app.account;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.common.UserDeviceEnum;
import com.gndc.common.enums.user.UserEventsTypeEnum;
import com.gndc.common.enums.user.UserStatusEnum;
import com.gndc.common.exception.HjException;
import com.gndc.common.utils.DateUtil;
import com.gndc.common.utils.PwdUtil;
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

        if (StrUtil.isBlank(request.getHeader().getDeviceType())) {
            throw new HjException(ResultCode.DEVICETYPE_ISNULL);
        }

        userInfo = userService.selectOneByProperty("phone", phone);
        byte deviceType = Byte.parseByte(request.getHeader().getDeviceType());


        if ((deviceType == UserDeviceEnum.ANDROID.getCode() || deviceType == UserDeviceEnum.IOS.getCode())) {
            if (StrUtil.isBlank(imei)) {
                throw new HjException(ResultCode.IMEI_TOKEN_ISNULL);
            }

            if (StrUtil.isBlank(termType)) {
                throw new HjException(ResultCode.TERM_TYPE_ISNULL);
            }

            if (userInfo == null) {
                throw new HjException(ResultCode.USER_NOT_EXISTS);
            }

            String passwordDec = PwdUtil.decrypt(password);
            String pwdMd5 = PwdUtil.passwordGenerate(passwordDec, userInfo.getPasswordSign());

            if (!pwdMd5.equals(userInfo.getPassword())) {
                throw new HjException(ResultCode.USER_NAME_PASSWORD_ERROR);
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

        if (StrUtil.isBlank(request.getHeader().getDeviceType())) {
            throw new HjException(ResultCode.DEVICETYPE_ISNULL);
        }

        byte deviceType = Byte.parseByte(request.getHeader().getDeviceType());

        if ((deviceType == UserDeviceEnum.ANDROID.getCode() || deviceType == UserDeviceEnum.IOS.getCode())) {
            if (StrUtil.isBlank(imei)) {
                throw new HjException(ResultCode.IMEI_TOKEN_ISNULL);
            }

            if (StrUtil.isBlank(termType)) {
                throw new HjException(ResultCode.TERM_TYPE_ISNULL);
            }
        }

        String key = P_SMS_USER_LOGIN + phone;

        String sms10MinuteCountStr = (String) redisTemplate.opsForValue().get(CacheConstant.KEY_USER_SMS_10_PREFIX + key);
        String smsInfoStr = (String) redisTemplate.opsForValue().get(CacheConstant.KEY_USER_SMS_15M_PREFIX + key);

        Sms10MinuteCount sms10MinuteCount = JSONObject.parseObject(sms10MinuteCountStr, Sms10MinuteCount.class);
        SmsInfo smsInfo = JSONObject.parseObject(smsInfoStr, SmsInfo.class);

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
            user.setUserStatus(UserStatusEnum.INFO_UNFILLED.getCode());
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
        if (StrUtil.isBlank(user.getPassword())) {
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

        String sessionId = IdUtil.simpleUUID();
        User userInfo = new User();
        userInfo.setId(userId);
        redisTemplate.opsForValue().set(CacheConstant.NAMESPACE_USER_LOGIN + sessionId, userInfo,
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
        User user = JSONObject.parseObject(userInfoStr, User.class);
        if (user == null) {
            throw new HjException(ResultCode.SESSIONID_ISNULL);
        }
        String password = request.getPassword();
        String newPassword = request.getNewPassword();
        String confirmPassword = request.getConfirmPassword();

        if (StrUtil.isBlank(newPassword) || StrUtil.isBlank(confirmPassword)) {
            throw new HjException(ResultCode.PARAM_MISSING);
        }

        try {
            if (StrUtil.isNotBlank(password)) {
                password = PwdUtil.decrypt(password);
            }

            newPassword = PwdUtil.decrypt(newPassword);

            confirmPassword = PwdUtil.decrypt(confirmPassword);

        } catch (Exception e) {
            throw new HjException(ResultCode.PARAMETER_ERROR);
        }

        // 从数据获取用户信息
        User userInfo = userService.selectByPrimaryKey(user.getId());
        if (StrUtil.isNotBlank(userInfo.getPassword()) && StrUtil.isBlank(password)) {
            throw new HjException(ResultCode.PASSWORD_ISNULL);
        }

        String passwordSign = userInfo.getPasswordSign();

        if (StrUtil.isNotBlank(userInfo.getPassword())) {

            if (!userInfo.getPassword().equals(PwdUtil.passwordGenerate(password, userInfo.getPasswordSign()))) {
                throw new HjException(ResultCode.OLD_PASSWORD_ERROR);
            }

        } else {
            if (!newPassword.equals(confirmPassword)) {
                throw new HjException(ResultCode.CONFIRM_PASSWORD_ERROR);
            }
        }

        passwordSign = RandomUtil.randomString(6);
        userInfo.setPasswordSign(passwordSign);
        userInfo.setPassword(PwdUtil.passwordGenerate(newPassword, passwordSign));
        int flag = userService.updatePassword(userInfo);
        if (flag <= 0) {
            throw new HjException(ResultCode.RECORD_MODIFY_FAIL);
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

        Sms10MinuteCount sms10MinuteCount = JSONObject.parseObject(sms10MinuteCountStr, Sms10MinuteCount.class);
        SmsInfo smsInfo = JSONObject.parseObject(smsInfoStr, SmsInfo.class);

        if (!smsLogService.validateSms(smsInfo, sms10MinuteCount, key, valCode, response)) {
            return response;
        }

        // 根据手机号查询出当前用户
        User user = userService.selectOneByProperty("phone", phone);
        if (null == user) {
            throw new HjException(ResultCode.USER_NOT_EXISTS);
        }

        String passwordSign = RandomUtil.randomString(6);
        user.setPasswordSign(passwordSign);

        password = PwdUtil.decrypt(password);
        confirmPassword = PwdUtil.decrypt(confirmPassword);
        if (!password.equals(confirmPassword)) {
            throw new HjException(ResultCode.CONFIRM_PASSWORD_ERROR);
        }

        user.setPassword(PwdUtil.passwordGenerate(password, passwordSign));
        int flag = userService.updatePassword(user);
        if (flag <= 0) {
            throw new HjException(ResultCode.RECORD_MODIFY_FAIL);
        }
        logger.info(String.format("应答:%s", JSONObject.toJSONString(response)));
        return response;
    }
}
