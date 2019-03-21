package com.gndc.core.controller.admin.sms;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.enums.common.DelEnum;
import com.gndc.core.api.admin.sms.*;
import com.gndc.core.api.common.CommonRequest;
import com.gndc.core.api.common.CommonResponse;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.mappers.SmsSignMapping;
import com.gndc.core.mappers.SmsTemplateMapping;
import com.gndc.core.model.Admin;
import com.gndc.core.model.SmsSign;
import com.gndc.core.model.SmsTemplate;
import com.gndc.core.service.sms.SmsChannelService;
import com.gndc.core.service.sms.SmsLogService;
import com.gndc.core.service.sms.SmsSignService;
import com.gndc.core.service.sms.SmsTemplateService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;

/**
 * 短信管理
 */
@RestController
@RequestMapping("/admin/smsManage")
public class AOSmsController {

    @Autowired
    private SmsChannelService smsChannelService;

    @Autowired
    private SmsTemplateService smsTemplateService;

    @Autowired
    private SmsSignService smsSignService;

    @Autowired
    private SmsLogService smsLogService;

    /**
     * 短信统计
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
     * 签名编辑
     * @param request
     * @return
     */
    @PostMapping("/sign/edit")
    public ResponseMessage<CommonResponse> signEdit(@Validated @RequestBody AOSmsSignEditRequest request) {
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        SmsSign smsSign = SmsSignMapping.INSTANCE.convert(request);
        CommonResponse commonResponse = new CommonResponse();
        if (request.getSignId() != null) {
            commonResponse.setResult(smsSignService.updateByPrimaryKeySelective(smsSign));
        } else {
            commonResponse.setResult(smsSignService.insertSelective(smsSign));
        }
        response.setData(commonResponse);
        return response;
    }
    /**
     * 签名列表
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
            criteria.andLike(SmsSign::getName,"%"+request.getName()+"%");
        }
        if(StringUtils.isNotBlank(request.getCreateTimeStart())){
            criteria.andGreaterThanOrEqualTo(SmsSign::getCreateTime,request.getCreateTimeStart());
        }
        if(StringUtils.isNotBlank(request.getCreateTimeEnd())){
            criteria.andLessThanOrEqualTo(SmsSign::getCreateTime,request.getCreateTimeEnd());
        }
        criteria.andEqualTo(SmsSign::getStatus, DelEnum.NORMAL.getCode());
        List<SmsSign> smsSigns = smsSignService.selectByExample(weekend);
        PageInfo<SmsSign> pageInfo = new PageInfo<>(smsSigns);
        response.setData(smsSigns);
        pageInfo.setList(null);
        response.setPage(pageInfo);
        return response;
    }
    /**
     * 编辑模板
     * @param request
     * @return
     */
    @PostMapping("/template/edit")
    public ResponseMessage<CommonResponse> templateEdit(@Validated @RequestBody AOSmsTemplateEditRequest request) {
        Admin admin = request.getAdmin();
        ResponseMessage<CommonResponse> response = new ResponseMessage<>();
        SmsTemplate smsTemplate = SmsTemplateMapping.INSTANCE.convert(request);
        CommonResponse commonResponse = new CommonResponse();
        if (request.getTemplateId() != null) {
            commonResponse.setResult(smsTemplateService.updateByPrimaryKeySelective(smsTemplate));
        } else {
            commonResponse.setResult(smsTemplateService.insertSelective(smsTemplate));
        }
        response.setData(commonResponse);
        return response;
    }

    /**
     * 模板列表
     * @param request
     * @return
     */
    @PostMapping("/template/list")
    public ResponseMessage<List<SmsTemplate>> templateList(@Validated @RequestBody AOSmsTemplateListRequest request) {
        ResponseMessage<List<SmsTemplate>> response = new ResponseMessage<>();
        PageInfo page = request.getHeader().getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        Weekend<SmsTemplate> weekend = Weekend.of(SmsTemplate.class);
        weekend.selectProperties("id", "name", "channelName", "createTime");
        WeekendCriteria<SmsTemplate, Object> criteria = weekend.weekendCriteria();
//        if (StringUtils.isNotBlank(request.getName())) {
//            criteria.andLike(SmsTemplate::getName,"%"+request.getName()+"%");
//        }
        if(StringUtils.isNotBlank(request.getCreateTimeStart())){
            criteria.andGreaterThanOrEqualTo(SmsTemplate::getCreateTime,request.getCreateTimeStart());
        }
        if(StringUtils.isNotBlank(request.getCreateTimeEnd())){
            criteria.andLessThanOrEqualTo(SmsTemplate::getCreateTime,request.getCreateTimeEnd());
        }
        criteria.andEqualTo(SmsTemplate::getStatus, DelEnum.NORMAL.getCode());
        List<SmsTemplate> smsTemplates = smsTemplateService.selectByExample(weekend);
        PageInfo<SmsTemplate> pageInfo = new PageInfo<>(smsTemplates);
        response.setData(smsTemplates);
        pageInfo.setList(null);
        response.setPage(pageInfo);
        return response;
    }


}
