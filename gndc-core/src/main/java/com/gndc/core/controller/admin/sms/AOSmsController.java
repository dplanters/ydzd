package com.gndc.core.controller.admin.sms;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.constant.SmsEditConstant;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.enums.sms.SmsChannelEnum;
import com.gndc.common.exception.HjException;
import com.gndc.core.api.admin.sms.*;
import com.gndc.core.api.common.CommonResponse;
import com.gndc.common.api.ResponseMessage;
import com.gndc.core.mappers.SmsConditionMapping;
import com.gndc.core.mappers.SmsSignMapping;
import com.gndc.core.mappers.SmsTemplateMapping;
import com.gndc.core.model.*;
import com.gndc.core.service.platform.SystemScheduleJobService;
import com.gndc.core.service.sms.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.*;

/**
 * 短信管理
 */
@RestController
@RequestMapping("/admin/smsManage")
public class AOSmsController {

    private static final Logger logger = LoggerFactory.getLogger(AOSmsController.class);

    @Autowired
    private SmsTemplateService smsTemplateService;

    @Autowired
    private SmsSignService smsSignService;

    @Autowired
    private SmsLogService smsLogService;

    @Autowired
    private SmsConditionService smsConditionService;

    @Autowired
    private SystemScheduleJobService systemScheduleJobService;

    @Autowired
    private SmsGroupLogService smsGroupLogService;

    /**
     * 短信统计
     *
     * @param request
     * @return
     */
    @PostMapping("/statistics")
    public ResponseMessage<List<AOSmsStatisticsResponse>> statistics(@Validated @RequestBody AOSmsStatisticsRequest request) {
        ResponseMessage<List<AOSmsStatisticsResponse>> response = new ResponseMessage<>();
        PageInfo page = request.getHeader().getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<AOSmsStatisticsResponse> smsStatisticsResponses = null;
        if (request.getType().equals(SmsEditConstant.STATISTICS_DIMENSION_1)) {
            smsStatisticsResponses = smsGroupLogService.groupLogStatisticsByDay(request);
        } else if (request.getType().equals(SmsEditConstant.STATISTICS_DIMENSION_2)) {
            smsStatisticsResponses = smsGroupLogService.groupLogStatisticsByMonth(request);
        }
        PageInfo<AOSmsStatisticsResponse> pageInfo = new PageInfo<>(smsStatisticsResponses);
        response.setData(smsStatisticsResponses);
        pageInfo.setList(null);
        response.setPage(pageInfo);
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
        if (request.getChannelId().equals(SmsEditConstant.CHANNEL_ID_1)) {
            smsSign.setChannelName("创蓝");
        }
        if (request.getChannelId().equals(SmsEditConstant.CHANNEL_ID_2)) {
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
        if (request.getChannelId().equals(SmsEditConstant.CHANNEL_ID_1)) {
            smsSign.setChannelName("创蓝");
        }
        if (request.getChannelId().equals(SmsEditConstant.CHANNEL_ID_2)) {
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
        weekend.selectProperties("id", "name", "channelId", "channelName", "createTime");
        WeekendCriteria<SmsSign, Object> criteria = weekend.weekendCriteria();
        if (StrUtil.isNotBlank(request.getName())) {
            criteria.andLike(SmsSign::getName, "%" + request.getName() + "%");
        }
        if (StrUtil.isNotBlank(request.getCreateTimeStart())) {
            criteria.andGreaterThanOrEqualTo(SmsSign::getCreateTime, request.getCreateTimeStart());
        }
        if (StrUtil.isNotBlank(request.getCreateTimeEnd())) {
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
        smsTemplate.setId(request.getTemplateId());
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
        if (smsConditions != null && smsConditions.size() > 0) {
            for (AOSmsConditionListResponse temp : smsConditions) {
                String condition = temp.getCondition();
                SmsConditionContent smsConditionContent = JSONObject.parseObject(condition, SmsConditionContent.class);
                //营销条件0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类
                if (smsConditionContent.getConditionType().equals(SmsEditConstant.CONDITION_TYPE_1)) {
                    if (smsConditionContent.getMarketingType().equals(SmsEditConstant.MARKETING_TYPE_1)) {
                        temp.setConditionText("最近" + smsConditionContent.getMarketingTime() + "天登录");
                    }
                    if (smsConditionContent.getMarketingType().equals(SmsEditConstant.MARKETING_TYPE_2)) {
                        temp.setConditionText("最近" + smsConditionContent.getMarketingTime() + "天注册");
                    }
                }
                if (smsConditionContent.getConditionType().equals(SmsEditConstant.CONDITION_TYPE_2)) {
                    Integer[] collectionTime = smsConditionContent.getCollectionTime();
                    if (collectionTime != null && collectionTime.length > 0) {
                        String collectionTimeText = StrUtil.join("、", collectionTime);
                        temp.setConditionText("逾期天数等于" + collectionTimeText + "天");
                    }
                }
                if (smsConditionContent.getConditionType().equals(SmsEditConstant.CONDITION_TYPE_3)) {
                    Integer[] remindTime = smsConditionContent.getRemindTime();
                    if (remindTime != null && remindTime.length > 0) {
                        String remindTimeText = StrUtil.join("、", remindTime);
                        temp.setConditionText("提醒天数等于" + remindTimeText + "天");
                    }
                }
                if (smsConditionContent.getConditionType().equals(SmsEditConstant.CONDITION_TYPE_4)) {
                    if (smsConditionContent.getNoticeType().equals(SmsEditConstant.NOTICE_TYPE_1)) {
                        temp.setConditionText("当日注册成功");
                    }
                    if (smsConditionContent.getNoticeType().equals(SmsEditConstant.NOTICE_TYPE_2)) {
                        temp.setConditionText("当日申请成功");
                    }
                }
            }
        }
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
        /**
         *
         *
         * 该方法要是改动，com.gndc.core.quartz.util.TaskUtils也需要同步改动
         *
         *
         */
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        //需要发送短信的号码用","隔开
        String phoneToSend = null;
        //通道
        String channel = "";
        Integer[] signArr = request.getSmsSignIds();
        //创蓝
        if (request.getChannelId().equals(SmsEditConstant.CHANNEL_ID_1)) {
            channel = SmsChannelEnum.CHUANGLAN.getCode();
        }
        //大汉三通
        if (request.getChannelId().equals(SmsEditConstant.CHANNEL_ID_2)) {
//            channel = SmsChannelEnum.CHUANGLAN.getCode();
        }
        //签名数组
        if (signArr.length > 0) {
            for (int i = 0; i < signArr.length; i++) {
                Integer signId = signArr[i];
                SmsSign smsSign = smsSignService.selectByPrimaryKey(signId);
                if (smsSign == null || smsSign.getStatus().equals(StatusEnum.DELETE.getCode())) {
                    throw new HjException(ResultCode.SIGN_NOT_EXIST);
                }
                String message = "";
                Integer templateId = request.getTemplateId();
                SmsTemplate smsTemplate = smsTemplateService.selectByPrimaryKey(templateId);
                if (smsTemplate == null || smsTemplate.getStatus().equals(StatusEnum.DELETE.getCode())) {
                    throw new HjException(ResultCode.TEMPLATE_NOT_EXIST);
                }
                message = smsSign.getName() + smsTemplate.getContent();
                if (request.getSourceType().equals(SmsEditConstant.SOURCE_TYPE_1)) {
                    SmsCondition smsCondition = smsConditionService.selectByPrimaryKey(request.getConditionId());
                    //当前支持营销类
                    if (smsCondition != null && smsCondition.getType().equals(SmsEditConstant.CONDITION_TYPE_1)) {
                        phoneToSend = smsLogService.searchPhones(smsCondition, request);
                    } else {
                        //暂时只支持营销类
                        throw new HjException(ResultCode.CONDITION_NOT_EXIST);
                    }

                } else if (request.getSourceType().equals(SmsEditConstant.SOURCE_TYPE_2)) {
                    phoneToSend = StrUtil.join(",", request.getPhones());
                }
                if (phoneToSend == null) {
                    throw new HjException(ResultCode.RECORD_NOT_EXIST);
                }
                SmsGroupLog smsGroupLog = new SmsGroupLog();
                smsGroupLog.setPhone(phoneToSend);
                smsGroupLog.setMessage(message);
                smsGroupLog.setChannelId(request.getChannelId());
                smsGroupLog.setConditionId(request.getConditionId());
                smsGroupLog.setSendType(SmsEditConstant.SEND_TYPE_2);
                smsGroupLog.setSignId(signId);
                smsGroupLog.setPhoneCount(phoneToSend.split(",").length);
                smsLogService.groupSendSmsJson(channel, phoneToSend, message, smsGroupLog);
            }
        } else {
            throw new HjException(ResultCode.SIGN_NOT_EXIST);
        }
        return response;
    }

    /**
     * 编辑短息-定时发送
     *
     * @param request
     * @return
     */
    @PostMapping("/timingSend")
    public ResponseMessage<CommonResponse> timingSend(@Validated @RequestBody AOSmsTimingSendRequest request) throws Exception {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(systemScheduleJobService.timingSendJob(request));
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
        List<AOSmsScheduleListResponse> smsJobDetailList = systemScheduleJobService.selectSmsJobDetailList(request);
        if (smsJobDetailList != null && smsJobDetailList.size() > 0) {
            Weekend<SmsSign> weekend = Weekend.of(SmsSign.class);
            weekend.selectProperties("id", "name");
            weekend.weekendCriteria().andEqualTo(SmsSign::getStatus,StatusEnum.NORMAL.getCode());
            List<SmsSign> smsSigns = smsSignService.selectByExample(weekend);

            for (AOSmsScheduleListResponse temp : smsJobDetailList) {
                String signIds = temp.getSignIds();
                if (StrUtil.isNotBlank(signIds)) {
                    StringBuffer signName = new StringBuffer();
                    for (SmsSign smsSignTemp : smsSigns) {
                        if (signIds.contains(",")) {
                            if (signIds.contains(smsSignTemp.getId().toString())) {
                                signName.append(smsSignTemp.getName()).append(",");
                            }
                        } else {
                            if (signIds.equals(smsSignTemp.getId().toString())) {
                                temp.setSignNames(smsSignTemp.getName());
                            }
                        }
                    }
                    if (signIds.contains(",")) {
                        String signNameStr = signName.substring(0, signName.length() - 1);
                        temp.setSignNames(signNameStr);
                    }
                }
                //是否是条件选择
                if (temp.getType() == null || temp.getType() == 0) {
                    temp.setSourceType(SmsEditConstant.SOURCE_TYPE_2);
                } else {
                    temp.setSourceType(SmsEditConstant.SOURCE_TYPE_1);
                }

                if (StrUtil.isNotBlank(temp.getExpression())) {
                    //发送：周  时间
                    String[] expressionArr = temp.getExpression().split(" ");
                    String weeksStr = expressionArr[5];
                    temp.setWeeks(weeksStr.split(","));
                    temp.setSendTime(expressionArr[2] + ":" + expressionArr[1]);
                    //发送日期
                    String month = expressionArr[4].length() == 1 ? "0" + expressionArr[4].length() : expressionArr[4];
                    String day = expressionArr[3].length() == 1 ? "0" + expressionArr[3].length() : expressionArr[3];
                    temp.setSendDate(expressionArr[6] + "-" + month + "-" + day);
                }
                //定时发送类型
                String sendStartDate = temp.getSendStartDate();
                if (StrUtil.isNotBlank(sendStartDate)) {
                    temp.setTimingSendType(SmsEditConstant.TIMING_SEND_TYPE_1);
                } else {
                    temp.setTimingSendType(SmsEditConstant.TIMING_SEND_TYPE_2);
                }
                //条件拼接
                String condition = temp.getCondition();
                if (StrUtil.isNotBlank(condition)) {

                    SmsConditionContent smsConditionContent = JSONObject.parseObject(condition, SmsConditionContent.class);
                    //营销条件0-未定义 1-营销类 2-催收类 3-提醒类 4-通知类
                    if (smsConditionContent.getConditionType().equals(SmsEditConstant.CONDITION_TYPE_1)) {
                        if (smsConditionContent.getMarketingType().equals(SmsEditConstant.MARKETING_TYPE_1)) {
                            temp.setConditionText("最近" + smsConditionContent.getMarketingTime() + "天登录");
                        }
                        if (smsConditionContent.getMarketingType().equals(SmsEditConstant.MARKETING_TYPE_2)) {
                            temp.setConditionText("最近" + smsConditionContent.getMarketingTime() + "天注册");
                        }
                    }
                    if (smsConditionContent.getConditionType().equals(SmsEditConstant.CONDITION_TYPE_2)) {
                        Integer[] collectionTime = smsConditionContent.getCollectionTime();
                        if (collectionTime != null && collectionTime.length > 0) {
                            String collectionTimeText = StrUtil.join("、", collectionTime);
                            temp.setConditionText("逾期天数等于" + collectionTimeText + "天");
                        }
                    }
                    if (smsConditionContent.getConditionType().equals(SmsEditConstant.CONDITION_TYPE_3)) {
                        Integer[] remindTime = smsConditionContent.getRemindTime();
                        if (remindTime != null && remindTime.length > 0) {
                            String remindTimeText = StrUtil.join("、", remindTime);
                            temp.setConditionText("提醒天数等于" + remindTimeText + "天");
                        }
                    }
                    if (smsConditionContent.getConditionType().equals(SmsEditConstant.CONDITION_TYPE_4)) {
                        if (smsConditionContent.getNoticeType().equals(SmsEditConstant.NOTICE_TYPE_1)) {
                            temp.setConditionText("当日注册成功");
                        }
                        if (smsConditionContent.getNoticeType().equals(SmsEditConstant.NOTICE_TYPE_2)) {
                            temp.setConditionText("当日申请成功");
                        }
                    }
                }
            }
        }
        PageInfo<AOSmsScheduleListResponse> pageInfo = new PageInfo<>(smsJobDetailList);
        pageInfo.setList(null);
        response.setPage(pageInfo);
        response.setData(smsJobDetailList);
        return response;
    }

    /**
     * 编辑短息-任务停止
     *
     * @param request
     * @return
     */
    @PostMapping("/schedule/stop")
    public ResponseMessage<CommonResponse> stopSchedule(@Validated @RequestBody AOSmsStopScheduleRequest request) throws Exception {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(systemScheduleJobService.stopSchedule(request));
        return response;
    }

    /**
     * 编辑短息-任务修改
     *
     * @param request
     * @return
     */
    @PostMapping("/updateTimingSend")
    public ResponseMessage<CommonResponse> updateTimingSend(@Validated @RequestBody AOSmsUpdateTimingSendRequest request) throws Exception {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setResult(systemScheduleJobService.updateTimingSendJob(request));
        return response;
    }

    /**
     * 短信群发发送记录
     *
     * @param request
     * @return
     */
    @PostMapping("/groupLog/list")
    public ResponseMessage<List<AOSmsGroupLogListResponse>> scheduleList(@Validated @RequestBody AOSmsGroupLogListRequest request) {
        ResponseMessage<List<AOSmsGroupLogListResponse>> response = new ResponseMessage<>();
        PageInfo page = request.getHeader().getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<AOSmsGroupLogListResponse> smsGroupLogLists = smsGroupLogService.selectSmsGroupLogDetailList(request);
        PageInfo<AOSmsGroupLogListResponse> pageInfo = new PageInfo<>(smsGroupLogLists);
        pageInfo.setList(null);
        response.setPage(pageInfo);
        response.setData(smsGroupLogLists);
        return response;
    }

}
