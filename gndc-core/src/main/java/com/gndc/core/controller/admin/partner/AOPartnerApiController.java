    /**************************************************************************
 * Copyright©2004-2016 浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称：互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.core.controller.admin.partner;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.api.RequestMessage;
import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.admin.partner.AOPartnerApiRequest;
import com.gndc.core.mappers.PartnerApiMapping;
import com.gndc.core.model.Partner;
import com.gndc.core.model.PartnerApi;
import com.gndc.core.service.partner.PartnerApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.List;

    /**
 * @author <a href="liujun8852@adpanshi.com">liujun</a>
 * @version V1.0.1
 * @Description
 * @date 2019/4/15  11:37
 */
@RestController
@RequestMapping("/admin/partnerApi")
public class AOPartnerApiController {

    private static final Logger logger = LoggerFactory.getLogger(AOPartnerApiController.class);

    @Autowired
    private PartnerApiMapping partnerApiMapping;
    @Autowired
    private PartnerApiService partnerApiService;

    @PostMapping("/addPartnerApi")
    public ResponseMessage addPartnerApi(@RequestBody AOPartnerApiRequest aoPartnerApiRequest){
        ResponseMessage responseMessage=new ResponseMessage<>();
        PartnerApi partnerApi = partnerApiMapping.toEntity(aoPartnerApiRequest);
        partnerApiService.insert(partnerApi);
        return responseMessage;
    }


    @PostMapping("/updatePartnerApi")
    public ResponseMessage updatePartnerApi(@RequestBody AOPartnerApiRequest aoPartnerApiRequest){
        ResponseMessage responseMessage=new ResponseMessage<>();
        PartnerApi partnerApi = partnerApiMapping.toEntity(aoPartnerApiRequest);
        partnerApiService.updateByPrimaryKeySelective(partnerApi);
        return responseMessage;
    }


    @PostMapping("/deletePartnerApi")
    public ResponseMessage deletePartnerApi(@RequestBody AOPartnerApiRequest aoPartnerApiRequest){
        ResponseMessage responseMessage=new ResponseMessage<>();
        PartnerApi partnerApi = partnerApiMapping.toEntity(aoPartnerApiRequest);
        Weekend<PartnerApi> weekend=new Weekend(PartnerApi.class);
        weekend.weekendCriteria().andEqualTo(PartnerApi::getId,partnerApi.getId());
        partnerApiService.updateByExampleSelective(partnerApi,weekend);
        return responseMessage;
    }

    @PostMapping("/getPartnerApiList")
    public ResponseMessage getPartnerApiList(@RequestBody AOPartnerApiRequest aoPartnerApiRequest){
        ResponseMessage responseMessage=new ResponseMessage<>();
        PartnerApi partnerApi = partnerApiMapping.toEntity(aoPartnerApiRequest);
        PageHelper.startPage(aoPartnerApiRequest.getPageNum(), aoPartnerApiRequest.getPageSize());

        Weekend<PartnerApi> weekend=new Weekend(PartnerApi.class);
        List<PartnerApi> partners = partnerApiService.selectByExample(weekend);
        PageInfo<PartnerApi> pageInfo = new PageInfo<>(partners);
        responseMessage.setPage(pageInfo);
        responseMessage.setData(partners);
        return responseMessage;
    }

}
