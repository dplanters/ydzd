    /**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.admin.controller.admin.partner;

    import com.github.pagehelper.PageHelper;
    import com.github.pagehelper.PageInfo;
    import com.gndc.common.api.ResponseMessage;
    import com.gndc.common.enums.common.StatusEnum;
    import com.gndc.admin.api.admin.partner.AOPartnerApiAddRequest;
    import com.gndc.admin.api.admin.partner.AOPartnerApiDeleteRequest;
    import com.gndc.admin.api.admin.partner.AOPartnerApiListRequest;
    import com.gndc.admin.api.admin.partner.AOPartnerApiModifyRequest;
    import com.gndc.admin.mappers.PartnerApiMapping;
    import com.gndc.common.model.PartnerApi;
    import com.gndc.admin.service.partner.PartnerApiService;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.validation.annotation.Validated;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    import tk.mybatis.mapper.weekend.Weekend;

    import java.util.Date;
    import java.util.List;

    /**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/15  11:37
 */
@Slf4j
@RestController
@RequestMapping("/admin/partnerApi")
public class AOPartnerApiController {

    @Autowired
    private PartnerApiMapping partnerApiMapping;
    @Autowired
    private PartnerApiService partnerApiService;

    @PostMapping("/addPartnerApi")
    public ResponseMessage addPartnerApi(@Validated @RequestBody AOPartnerApiAddRequest aoPartnerApiAddRequest){
        ResponseMessage responseMessage=new ResponseMessage<>();
        PartnerApi partnerApi = partnerApiMapping.convert(aoPartnerApiAddRequest);
        partnerApi.setCreateTime(new Date());
        partnerApiService.insertSelective(partnerApi);
        return responseMessage;
    }


    @PostMapping("/updatePartnerApi")
    public ResponseMessage updatePartnerApi(@Validated @RequestBody AOPartnerApiModifyRequest aoPartnerApiModifyRequest){
        ResponseMessage responseMessage=new ResponseMessage<>();
        PartnerApi partnerApi = partnerApiMapping.convert(aoPartnerApiModifyRequest);
        partnerApi.setUpdateTime(new Date());
        partnerApiService.updateByPrimaryKeySelective(partnerApi);
        return responseMessage;
    }


    @PostMapping("/deletePartnerApi")
    public ResponseMessage deletePartnerApi(@Validated @RequestBody AOPartnerApiDeleteRequest aoPartnerApiDeleteRequest){
        ResponseMessage responseMessage=new ResponseMessage<>();
        PartnerApi partnerApi = partnerApiMapping.convert(aoPartnerApiDeleteRequest);
        Weekend<PartnerApi> weekend=new Weekend(PartnerApi.class);
        weekend.weekendCriteria().andEqualTo(PartnerApi::getId,partnerApi.getId());
        partnerApi.setStatus(StatusEnum.DELETE.getCode());
        partnerApiService.updateByExampleSelective(partnerApi,weekend);
        return responseMessage;
    }

    @PostMapping("/getPartnerApiList")
    public ResponseMessage getPartnerApiList(@Validated @RequestBody AOPartnerApiListRequest aoPartnerApiListRequest){
        ResponseMessage responseMessage=new ResponseMessage<>();
        PartnerApi partnerApi = partnerApiMapping.convert(aoPartnerApiListRequest);
        PageHelper.startPage(aoPartnerApiListRequest.getPageNum(), aoPartnerApiListRequest.getPageSize());

        Weekend<PartnerApi> weekend=new Weekend(PartnerApi.class);
        List<PartnerApi> partners = partnerApiService.selectByExample(weekend);
        PageInfo<PartnerApi> pageInfo = new PageInfo<>(partners);
        responseMessage.setPage(pageInfo);
        responseMessage.setData(partners);
        return responseMessage;
    }

}
