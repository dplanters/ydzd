package com.gndc.admin.client;

import com.gndc.common.api.ResponseMessage;
import com.gndc.common.model.PartnerApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/22
 */
@FeignClient(name = "gndc-core")
public interface PartnerApiClient {

    @GetMapping("/provider/partnerApi/detail")
    ResponseMessage<PartnerApi> detail(@RequestParam("partnerId") Integer partnerId,
                                       @RequestParam("apiType") Integer apiType);
}