package com.gndc.admin.controller.provider;

import cn.hutool.core.util.ObjectUtil;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;
import com.gndc.common.model.PartnerApi;
import com.gndc.admin.service.partner.PartnerApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/29
 */
@Slf4j
@RestController
@RequestMapping("/provider/partnerApi")
public class PartnerApiController {

    @Autowired
    private PartnerApiService partnerApiService;

    /**
     * 获取请求商户的url
     * @return
     */
    @GetMapping("/detail")
    public ResponseMessage<PartnerApi> detail(@RequestParam("partnerId") Integer partnerId,
                                              @RequestParam("apiType") Integer apiType) {
        ResponseMessage<PartnerApi> response = new ResponseMessage<>();
        Weekend<PartnerApi> weekend = Weekend.of(PartnerApi.class);
        weekend.weekendCriteria()
                .andEqualTo(PartnerApi::getPartnerId, partnerId)
                .andEqualTo(PartnerApi::getApiType, apiType);
        PartnerApi partnerApi = partnerApiService.selectOneByExample(weekend);
        if (ObjectUtil.isNull(partnerApi)) {
            throw new HjException(ResultCode.RECORD_NOT_EXIST);
        }
        response.setData(partnerApi);
        return response;
    }

}
