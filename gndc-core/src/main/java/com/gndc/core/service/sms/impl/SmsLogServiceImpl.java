package com.gndc.core.service.sms.impl;

import com.alibaba.fastjson.JSONObject;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.constant.Constant;
import com.gndc.common.constant.SmsEditConstant;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.sms.SmsChannelEnum;
import com.gndc.common.enums.sms.SmsTemplateType;
import com.gndc.common.exception.HjException;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.common.utils.DateUtil;
import com.gndc.common.utils.PhoneUtil;
import com.gndc.core.api.admin.sms.AOSmsRealTimeSendRequest;
import com.gndc.core.api.admin.sms.SmsConditionContent;
import com.gndc.core.api.app.platform.Sms10MinuteCount;
import com.gndc.core.api.app.platform.Sms24HourCount;
import com.gndc.core.api.app.platform.SmsInfo;
import com.gndc.common.api.ResponseMessage;
import com.gndc.core.model.SmsCondition;
import com.gndc.core.model.SmsGroupLog;
import com.gndc.core.model.SmsLog;
import com.gndc.core.model.User;
import com.gndc.core.service.sms.SmsGroupLogService;
import com.gndc.core.service.sms.SmsLogService;
import com.gndc.core.service.user.UserService;
import com.gndc.third.sms.chuanglan.ChuangLanSmsService;
import com.gndc.third.sms.paasoo.PaasooSmsService;
import com.gndc.third.sms.paasoo.enums.PaasooSendResultType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.text.MessageFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 短信记录
 */
@Service
public class SmsLogServiceImpl extends BaseServiceImpl<SmsLog, Integer> implements SmsLogService {
    private static final Logger logger = LoggerFactory.getLogger(SmsLogServiceImpl.class);
    /**
     * 发送短信并发线程数。
     */
    private static final int CONCURRENCE = 2;

    @Autowired
    private PaasooSmsService paasooSmsService;

    @Autowired
    private ChuangLanSmsService chuangLanSmsService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SmsLogService smsLogService;

    @Autowired
    private SmsGroupLogService smsGroupLogService;

    @Autowired
    private UserService userService;

    @Override
    public void sendValCodeSms(String code, String phone, SmsTemplateType userForgetPwd, String valCode, int i, String key, Sms10MinuteCount sms10MinuteCount, Sms24HourCount sms24HourCount) throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(CONCURRENCE);
        pool.execute(new ValCodeSmsThread(code, phone, userForgetPwd, valCode, i, key, sms10MinuteCount, sms24HourCount));
        pool.shutdown();
        while (!pool.isTerminated()) {
            pool.awaitTermination(5, TimeUnit.SECONDS);
        }
    }

    class ValCodeSmsThread implements Runnable {

        // 通道
        private String channel;
        // 手机号
        private String phone;
        // 短信类型
        private SmsTemplateType smsTemplateType;
        // 验证码
        private String valCode;
        // 用户id
        private int userId;
        // key
        private String key;

        private Sms10MinuteCount sms10MinuteCount;

        private Sms24HourCount sms24HourCount;

        // private ISmsService smsService;

        public ValCodeSmsThread(String channel, String phone, SmsTemplateType smsTemplateType, String valCode, int userId,
                                String key, Sms10MinuteCount sms10MinuteCount, Sms24HourCount sms24HourCount) {
            this.channel = channel;
            this.phone = phone;
            this.smsTemplateType = smsTemplateType;
            this.valCode = valCode;
            this.userId = userId;
            this.key = key;
            this.sms10MinuteCount = sms10MinuteCount;
            this.sms24HourCount = sms24HourCount;

        }

        /**
         * Description
         *
         * @see Runnable#run()
         */
        @Override
        public void run() {
            try {
                String valCodeStr = String.valueOf(valCode);
                String message = MessageFormat.format(smsTemplateType.getI18NContent(), valCodeStr);

                Map<String, String> sendResult = new HashMap<>();

                if (channel.equals(SmsChannelEnum.PAASOO.getCode())) {
                    sendResult = paasooSmsService.sendSms(phone, message, smsTemplateType);
                } else if (channel.equals(SmsChannelEnum.CHUANGLAN.getCode())) {
                    sendResult = chuangLanSmsService.sendSms(phone, message, smsTemplateType);
                }

                String status = null;
                // 短信发送日志
                Date now = DateUtil.getCountyTime();
                SmsLog sl = new SmsLog();
                sl.setMobile(phone);
                sl.setUserId(userId);
                sl.setSmsType(smsTemplateType.getCode());
                sl.setSmsParam(valCodeStr);
                sl.setMessage(message);
                sl.setCreateTime(now);
                sl.setUpdateTime(now);
                sl.setThirdChannel(channel);

                if (channel.equals(SmsChannelEnum.PAASOO.getCode())) {
                    status = sendResult.get("bannerStatus");
                    sl.setPaasooPhoneValErrcode(sendResult.get("phoneValidateErrorCode"));
                    sl.setPaasooPhoneValFormat(sendResult.get("phoneValidateFormat"));
                    sl.setPaasooPhoneValStr(sendResult.get("phoneValidateStr"));

                    sl.setPaasooSmsMessageid(sendResult.get("messageid"));
                    sl.setPaasooSmsStatus(status);
                    sl.setPaasooSmsStatusCode(sendResult.get("statusCode"));
                    sl.setPaasooSmsStr(sendResult.get("response"));

                } else if (channel.equals(SmsChannelEnum.CHUANGLAN.getCode())) {
                    status = sendResult.get("code");
                    sl.setPaasooPhoneValFormat(sendResult.get("errorMsg"));
                    sl.setPaasooPhoneValStr(sendResult.get("phoneValidateStr"));

                    sl.setPaasooSmsMessageid(sendResult.get("msgId"));
                    sl.setPaasooSmsStatus(sendResult.get("code"));
                    sl.setPaasooSmsStatusCode(sendResult.get("code"));
                    sl.setPaasooSmsStr(sendResult.get("response"));
                }

                smsLogService.insertSelective(sl);

                if (status.equals(PaasooSendResultType.SUCCESS.getStatus())) {

                    if (sms10MinuteCount == null) {
                        sms10MinuteCount = new Sms10MinuteCount();
                    }

                    if (sms24HourCount == null) {
                        sms24HourCount = new Sms24HourCount();
                    }


                    sms10MinuteCount.setCount(sms10MinuteCount.getCount() + 1);
                    String JsonText10M = JSONObject.toJSONString(sms10MinuteCount);
                    redisTemplate.opsForValue().set(CacheConstant.KEY_USER_SMS_10_PREFIX + key, JsonText10M, CacheConstant.EXPIRE_USER_SMS_10, TimeUnit.SECONDS);

                    sms24HourCount.setCount(sms24HourCount.getCount() + 1);
                    String jsonText24H = JSONObject.toJSONString(sms24HourCount);
                    redisTemplate.opsForValue().set(CacheConstant.KEY_USER_SMS_24H_PREFIX + key, jsonText24H, CacheConstant.EXPIRE_USER_SMS_24H, TimeUnit.SECONDS);

                    SmsInfo sms = new SmsInfo();
                    sms.setValCode(String.valueOf(valCode));
                    String jsonTextSms = JSONObject.toJSONString(sms);
                    redisTemplate.opsForValue().set(CacheConstant.KEY_USER_SMS_15M_PREFIX + key, jsonTextSms, CacheConstant.EXPIRE_USER_SMS_15M, TimeUnit.SECONDS);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 发送验证码时校验是否条数超限
     *
     * @param sms10MinuteCount
     * @param response
     * @return
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public boolean validateSmsCount(Sms10MinuteCount sms10MinuteCount, Sms24HourCount sms24HourCount,
                                    ResponseMessage<?> response) {

        if (sms10MinuteCount == null) {
            sms10MinuteCount = new Sms10MinuteCount();
        }

        if (sms10MinuteCount.getFailCount() >= Constant.SMS_FAIL_COUNT_LIMIT) {
            throw new HjException(ResultCode.AUTH_FAIL_COUNT);
        }

        if (sms10MinuteCount.getCount() >= Constant.SMS_COUNT_LIMIT_TEN_MINTUE) {
            throw new HjException(ResultCode.AUTH_COUNT_TEN_LIMIT);
        }

        if (sms24HourCount == null) {
            sms24HourCount = new Sms24HourCount();
        }
        if (sms24HourCount.getCount() >= Constant.SMS_COUNT_LIMIT_24_HOUR) {
            throw new HjException(ResultCode.AUTH_COUNT_24_HOUR);
        }

        return true;
    }

    /**
     * 校验短信是否正确
     *
     * @param sms
     * @param sms10MinuteCount
     * @param key
     * @param valCode
     * @param response
     * @return
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    public boolean validateSms(SmsInfo sms, Sms10MinuteCount sms10MinuteCount, String key, String valCode,
                               ResponseMessage<?> response) {
        if (sms == null) {
            throw new HjException(ResultCode.AUTH_INVALID);
        }

        if (sms10MinuteCount == null) {
            return false;
        }

        if (!valCode.equals(sms.getValCode())) {
            sms10MinuteCount.setFailCount(sms10MinuteCount.getFailCount() + 1);
            String JsonText10M = JSONObject.toJSONString(sms10MinuteCount);
            redisTemplate.opsForValue().set(CacheConstant.KEY_USER_SMS_10_PREFIX + key, JsonText10M, CacheConstant.EXPIRE_USER_SMS_10, TimeUnit.SECONDS);
            throw new HjException(ResultCode.AUTH_ERROR);
        }

        return true;
    }

    @Override
    public void groupSendSmsJson(String channel, String phone, String smsText, SmsGroupLog smsGroupLog) throws Exception {
        Map<String, String> sendResult = new HashMap<>();

        if (channel.equals(SmsChannelEnum.PAASOO.getCode())) {
            sendResult = paasooSmsService.sendSms(phone, smsText, null);
        } else if (channel.equals(SmsChannelEnum.CHUANGLAN.getCode())) {
            sendResult = chuangLanSmsService.sendSms(phone, smsText, null);
        }
        // 短信群发发送日志
        if (channel.equals(SmsChannelEnum.PAASOO.getCode())) {

        } else if (channel.equals(SmsChannelEnum.CHUANGLAN.getCode())) {
            String failNum = sendResult.get("failNum");
            String successNum = sendResult.get("successNum");
            if (failNum != null) {
                smsGroupLog.setFailNum(Integer.parseInt(failNum));
            }
            if (successNum != null) {
                smsGroupLog.setSuccessNum(Integer.parseInt(successNum));
            }
            smsGroupLog.setUid(sendResult.get("uid"));
            logger.info(JSONObject.toJSONString(sendResult));
            smsGroupLog.setPaasooPhoneValStr(sendResult.get("phoneValidateStr"));
        }

        smsGroupLogService.insertSelective(smsGroupLog);
    }

    @Override
    public String searchPhones(SmsCondition smsCondition, AOSmsRealTimeSendRequest request) {
        //条件类型json
        String condition = smsCondition.getCondition();
        SmsConditionContent smsConditionContent = JSONObject.parseObject(condition, SmsConditionContent.class);
        //营销事件1登录 2注册
        Byte marketingType = smsConditionContent.getMarketingType();
        //营销时间
        Integer marketingTime = smsConditionContent.getMarketingTime();
        Weekend<User> weekend = Weekend.of(User.class);
        weekend.selectProperties("phone");
        WeekendCriteria<User, Object> criteria = weekend.weekendCriteria();

        //当前时间减去营销时间
        String beginTime = DateUtil.nowDateAddDays(-marketingTime, DateUtil.FORMAT_2);
        Date currentTime = new Date();
        String endTime = DateUtil.timeToString(currentTime, DateUtil.FORMAT_2);

        if (marketingType.equals(SmsEditConstant.MARKETING_TYPE_1)) {
            criteria.andBetween(User::getLastLoginTime, beginTime, endTime);
        }
        if (marketingType.equals(SmsEditConstant.MARKETING_TYPE_2)) {
            criteria.andBetween(User::getRegTime, beginTime, endTime);
        }

        List<User> users = userService.selectByExample(weekend);
        if (users != null && users.size() > 0) {
            StringBuffer phoneBuffer = new StringBuffer();
            for (User temp : users) {
                //创蓝
                if (request.getChannelId().equals(SmsEditConstant.CHANNEL_ID_1)) {
                    //筛选出相应的运营商
                    if (Arrays.asList(request.getOperatorIds()).contains(SmsEditConstant.OPERATOR_ID_1)) {
                        if (PhoneUtil.isChinaMobilePhoneNum(temp.getPhone()).equals(SmsEditConstant.OPERATOR_ID_1)) {
                            phoneBuffer.append(temp.getPhone()).append(",");
                        }
                    }
                    if (Arrays.asList(request.getOperatorIds()).contains(SmsEditConstant.OPERATOR_ID_2)) {
                        if (PhoneUtil.isChinaMobilePhoneNum(temp.getPhone()).equals(SmsEditConstant.OPERATOR_ID_2)) {
                            phoneBuffer.append(temp.getPhone()).append(",");
                        }
                    }
                    if (Arrays.asList(request.getOperatorIds()).contains(SmsEditConstant.OPERATOR_ID_3)) {
                        if (PhoneUtil.isChinaMobilePhoneNum(temp.getPhone()).equals(SmsEditConstant.OPERATOR_ID_3)) {
                            phoneBuffer.append(temp.getPhone()).append(",");
                        }
                    }
                }
                //大汉三通
                if (request.getChannelId().equals(SmsEditConstant.CHANNEL_ID_2)) {

                }
            }
            return phoneBuffer.substring(0, phoneBuffer.length() - 1);
        } else {
            return null;
        }
    }
}
