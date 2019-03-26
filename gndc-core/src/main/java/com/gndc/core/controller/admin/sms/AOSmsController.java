package com.gndc.core.controller.admin.sms;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.enums.sms.SmsChannelEnum;
import com.gndc.common.utils.DateUtil;
import com.gndc.common.utils.JsonUtil;
import com.gndc.common.utils.PhoneUtil;
import com.gndc.core.api.admin.sms.*;
import com.gndc.core.api.common.CommonResponse;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.mappers.SmsConditionMapping;
import com.gndc.core.mappers.SmsSignMapping;
import com.gndc.core.mappers.SmsTemplateMapping;
import com.gndc.core.model.*;
import com.gndc.core.service.sms.*;
import com.gndc.core.service.user.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 短信管理
 */
@RestController
@RequestMapping("/admin/smsManage")
public class AOSmsController {

    /**
     * 1条件筛选 2导入
     */
    private static final Byte SOURCE_TYPE_1 = 1;
    /**
     * 1条件筛选 2导入
     */
    private static final Byte SOURCE_TYPE_2 = 2;

    /**
     * 营销条件0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类
     * 当前支持营销类
     */
    private static final Byte CONDITION_TYPE_1 = 1;

    /**
     * 营销事件1登录 2注册
     */
    private static final Byte MARKETING_TYPE_1 = 1;

    /**
     * 营销事件1登录 2注册
     */
    private static final Byte MARKETING_TYPE_2 = 2;
    /**
     * 渠道id 1创蓝2大汉三通
     */
    private static final Byte CHANNEL_ID_1 = 1;
    /**
     * 渠道id 1创蓝2大汉三通
     */
    private static final Byte CHANNEL_ID_2 = 2;
    /**
     * 运营商id 1:移动，2：联通，3：电信
     */
    private static final Integer OPERATOR_ID_1 = 1;
    /**
     * 运营商id 1:移动，2：联通，3：电信
     */
    private static final Integer OPERATOR_ID_2 = 2;
    /**
     * 运营商id 1:移动，2：联通，3：电信
     */
    private static final Integer OPERATOR_ID_3 = 3;

    private Byte marketingType;

    @Autowired
    private SmsChannelService smsChannelService;

    @Autowired
    private SmsTemplateService smsTemplateService;

    @Autowired
    private SmsSignService smsSignService;

    @Autowired
    private SmsLogService smsLogService;

    @Autowired
    private SmsConditionService smsConditionService;

    @Autowired
    private UserService userService;

    /**
     * 短信统计
     *
     * @param request
     * @return
     */
    @PostMapping("/statistics")
    public ResponseMessage<List<AOSmsStatisticsResponse>> statistics(@Validated @RequestBody AOSmsStatisticsRequest request) {
        ResponseMessage<List<AOSmsStatisticsResponse>> response = new ResponseMessage<>();


        response.setData(null);
        return response;
    }

    /**
     * 签名添加
     *
     * @param request
     * @return
     */
    @PostMapping("/sign/add")
    public ResponseMessage<CommonResponse> signAdd(@Validated @RequestBody AOSmsSignAddRequest request) {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        SmsSign smsSign = SmsSignMapping.INSTANCE.convert(request);
        if(request.getChannelId() == CHANNEL_ID_1 + ""){
            smsSign.setChannelName("创蓝");
        }
        if(request.getChannelId() == CHANNEL_ID_2 + ""){
            smsSign.setChannelName("大汉三通");
        }
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(smsSignService.insertSelective(smsSign));
        response.setData(commonResponse);
        return response;
    }

    /**
     * 签名更新
     *
     * @param request
     * @return
     */
    @PostMapping("/sign/update")
    public ResponseMessage<CommonResponse> signUpdate(@Validated @RequestBody AOSmsSignUpdateRequest request) {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        SmsSign smsSign = SmsSignMapping.INSTANCE.convert(request);
        CommonResponse commonResponse = new CommonResponse();
        if(request.getChannelId() == CHANNEL_ID_1 + ""){
            smsSign.setChannelName("创蓝");
        }
        if(request.getChannelId() == CHANNEL_ID_2 + ""){
            smsSign.setChannelName("大汉三通");
        }
        commonResponse.setResult(smsSignService.updateByPrimaryKeySelective(smsSign));
        response.setData(commonResponse);
        return response;
    }

    /**
     * 签名删除
     *
     * @param request
     * @return
     */
    @PostMapping("/sign/delete")
    public ResponseMessage<CommonResponse> signDelete(@Validated @RequestBody AOSmsSignDeleteRequest request) {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        SmsSign smsSign = new SmsSign();
        smsSign.setId(request.getSignId());
        smsSign.setStatus(StatusEnum.DELETE.getCode());
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(smsSignService.updateByPrimaryKeySelective(smsSign));
        response.setData(commonResponse);
        return response;
    }

    /**
     * 签名列表
     *
     * @param request
     * @return
     */
    @PostMapping("/sign/list")
    public ResponseMessage<List<SmsSign>> signList(@Validated @RequestBody AOSmsSignListRequest request) {
        ResponseMessage<List<SmsSign>> response = new ResponseMessage<>();
        PageInfo page = request.getHeader().getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        Weekend<SmsSign> weekend = Weekend.of(SmsSign.class);
        weekend.selectProperties("id", "name", "channelName", "createTime");
        WeekendCriteria<SmsSign, Object> criteria = weekend.weekendCriteria();
        if (StringUtils.isNotBlank(request.getName())) {
            criteria.andLike(SmsSign::getName, "%" + request.getName() + "%");
        }
        if (StringUtils.isNotBlank(request.getCreateTimeStart())) {
            criteria.andGreaterThanOrEqualTo(SmsSign::getCreateTime, request.getCreateTimeStart());
        }
        if (StringUtils.isNotBlank(request.getCreateTimeEnd())) {
            criteria.andLessThanOrEqualTo(SmsSign::getCreateTime, request.getCreateTimeEnd());
        }
        criteria.andEqualTo(SmsSign::getStatus, StatusEnum.NORMAL.getCode());
        List<SmsSign> smsSigns = smsSignService.selectByExample(weekend);
        PageInfo<SmsSign> pageInfo = new PageInfo<>(smsSigns);
        response.setData(smsSigns);
        pageInfo.setList(null);
        response.setPage(pageInfo);
        return response;
    }

    /**
     * 新增模板
     *
     * @param request
     * @return
     */
    @PostMapping("/template/add")
    public ResponseMessage<CommonResponse> templateAdd(@Validated @RequestBody AOSmsTemplateAddRequest request) {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        SmsTemplate smsTemplate = SmsTemplateMapping.INSTANCE.convert(request);
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(smsTemplateService.insertSelective(smsTemplate));
        response.setData(commonResponse);
        return response;
    }

    /**
     * 更新模板
     *
     * @param request
     * @return
     */
    @PostMapping("/template/update")
    public ResponseMessage<CommonResponse> templateUpdate(@Validated @RequestBody AOSmsTemplateUpdateRequest request) {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        SmsTemplate smsTemplate = SmsTemplateMapping.INSTANCE.convert(request);
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(smsTemplateService.updateByPrimaryKeySelective(smsTemplate));
        response.setData(commonResponse);
        return response;
    }

    /**
     * 删除模板
     *
     * @param request
     * @return
     */
    @PostMapping("/template/delete")
    public ResponseMessage<CommonResponse> templateDelete(@Validated @RequestBody AOSmsTemplateDeleteRequest request) {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        SmsTemplate smsTemplate = new SmsTemplate();
        smsTemplate.setStatus(StatusEnum.DELETE.getCode());
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(smsTemplateService.updateByPrimaryKeySelective(smsTemplate));
        response.setData(commonResponse);
        return response;
    }

    /**
     * 模板列表
     *
     * @param request
     * @return
     */
    @PostMapping("/template/list")
    public ResponseMessage<List<AOSmsTemplateListResponse>> templateList(@Validated @RequestBody AOSmsTemplateListRequest request) {
        ResponseMessage<List<AOSmsTemplateListResponse>> response = new ResponseMessage<>();
        PageInfo page = request.getHeader().getPage();
        if (page != null) {
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }
        List<AOSmsTemplateListResponse> smsTemplates = smsTemplateService.selectTemplateWithAdminList(request);
        if (page != null) {
            PageInfo<AOSmsTemplateListResponse> pageInfo = new PageInfo<>(smsTemplates);
            pageInfo.setList(null);
            response.setPage(pageInfo);
        }
        response.setData(smsTemplates);
        return response;
    }

    /**
     * 条件列表
     *
     * @param request
     * @return
     */
    @PostMapping("/condition/list")
    public ResponseMessage<List<AOSmsConditionListResponse>> conditionList(@Validated @RequestBody AOSmsConditionListRequest request) {
        ResponseMessage<List<AOSmsConditionListResponse>> response = new ResponseMessage<>();
        PageInfo page = request.getHeader().getPage();
        if (page != null) {
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }
        List<AOSmsConditionListResponse> smsConditions = smsConditionService.selectConditionWithAdminList(request);
        if (page != null) {
            PageInfo<AOSmsConditionListResponse> pageInfo = new PageInfo<>(smsConditions);
            pageInfo.setList(null);
            response.setPage(pageInfo);
        }
        response.setData(smsConditions);
        return response;
    }

    /**
     * 编辑条件
     *
     * @param request
     * @return
     */
    @PostMapping("/condition/add")
    public ResponseMessage<CommonResponse> conditionAdd(@Validated @RequestBody AOSmsConditionAddRequest request) {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        SmsCondition condition = SmsConditionMapping.INSTANCE.convert(request);
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(smsConditionService.insertSelective(condition));
        response.setData(commonResponse);
        return response;
    }

    /**
     * 更新条件
     *
     * @param request
     * @return
     */
    @PostMapping("/condition/update")
    public ResponseMessage<CommonResponse> conditionUpdate(@Validated @RequestBody AOSmsConditionUpdateRequest request) {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        SmsCondition condition = SmsConditionMapping.INSTANCE.convert(request);
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(smsConditionService.updateByPrimaryKeySelective(condition));
        response.setData(commonResponse);
        return response;
    }

    /**
     * 删除条件
     *
     * @param request
     * @return
     */
    @PostMapping("/condition/delete")
    public ResponseMessage<CommonResponse> conditionEdit(@Validated @RequestBody AOSmsConditionDeleteRequest request) {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        SmsCondition condition = new SmsCondition();
        condition.setId(request.getConditionId());
        condition.setStatus(StatusEnum.DELETE.getCode());
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(smsConditionService.updateByPrimaryKeySelective(condition));
        response.setData(commonResponse);
        return response;
    }


    /**
     * 编辑短息-实时发送
     *
     * @param request
     * @return
     */
    @PostMapping("/realTimeSend")
    public ResponseMessage<CommonResponse> realTimeSend(@Validated @RequestBody AOSmsRealTimeSendRequest request) throws Exception {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        //需要发送短信的号码用","隔开
        String phoneToSend = "";
        //通道
        String channel = "";
        Integer templateId = request.getTemplateId();
        SmsTemplate smsTemplate = smsTemplateService.selectByPrimaryKey(templateId);
        if (request.getSourceType() == SOURCE_TYPE_1) {
            SmsCondition smsCondition = smsConditionService.selectByPrimaryKey(request.getConditionId());
            //当前支持营销类
            if (smsCondition != null && smsCondition.getType() == CONDITION_TYPE_1) {
                //条件类型json
                String condition = smsCondition.getCondition();
                SmsConditionContent smsConditionContent = JsonUtil.getObject(condition, SmsConditionContent.class);
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


                if (marketingType == MARKETING_TYPE_1) {
                    criteria.andBetween(User::getLastLoginTime, beginTime, endTime);
                }
                if (marketingType == MARKETING_TYPE_2) {
                    criteria.andBetween(User::getRegTime, beginTime, endTime);
                }

                List<User> users = userService.selectByExample(weekend);
                if (users != null && users.size() > 0) {
                    StringBuffer phoneBuffer = new StringBuffer();
                    for (User temp : users) {
                        //创蓝
                        if (request.getChannelId() == CHANNEL_ID_1) {
                            channel = SmsChannelEnum.CHUANGLAN.getCode();
                            //筛选出相应的运营商
                            if (Arrays.asList(request.getOperatorId()).contains(OPERATOR_ID_1)) {
                                if (PhoneUtil.isChinaMobilePhoneNum(temp.getPhone()) == OPERATOR_ID_1) {
                                    phoneBuffer.append(temp.getPhone()).append(",");
                                }
                            }
                            if (Arrays.asList(request.getOperatorId()).contains(OPERATOR_ID_2)) {
                                if (PhoneUtil.isChinaMobilePhoneNum(temp.getPhone()) == OPERATOR_ID_2) {
                                    phoneBuffer.append(temp.getPhone()).append(",");
                                }
                            }
                            if (Arrays.asList(request.getOperatorId()).contains(OPERATOR_ID_3)) {
                                if (PhoneUtil.isChinaMobilePhoneNum(temp.getPhone()) == OPERATOR_ID_3) {
                                    phoneBuffer.append(temp.getPhone()).append(",");
                                }
                            }
                        }
                        //大汉三通
                        if (request.getChannelId() == CHANNEL_ID_2) {

                        }
                    }
                    phoneToSend = phoneBuffer.substring(0, phoneBuffer.length() - 1);

                }
            } else {
                return response;
            }

        } else if (request.getSourceType() == SOURCE_TYPE_2) {
            phoneToSend = request.getPhones();
        }
        smsLogService.groupSendSmsJson(channel, phoneToSend, smsTemplate.getContent());
        return response;
    }

    /**
     * 任务列表
     *
     * @param request
     * @return
     */
    @PostMapping("/schedule/list")
    public ResponseMessage<List<AOSmsScheduleListResponse>> scheduleList(@Validated @RequestBody AOSmsScheduleListRequest request) {
        ResponseMessage<List<AOSmsScheduleListResponse>> response = new ResponseMessage<>();
        PageInfo page = request.getHeader().getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
//        List<AOSmsScheduleListResponse> smsConditions = smsConditionService.selectConditionWithAdminList(request);
        List<AOSmsScheduleListResponse> smsConditions = null;
        PageInfo<AOSmsScheduleListResponse> pageInfo = new PageInfo<>(smsConditions);
        pageInfo.setList(null);
        response.setPage(pageInfo);
        response.setData(smsConditions);
        return response;
    }

}
