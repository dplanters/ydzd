package com.gndc.core.client;

import com.gndc.common.api.ResponseMessage;
import com.gndc.core.model.Partner;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/22
 */
@FeignClient(name = "gndc-core")
public interface PartnerClient {

    @GetMapping("/provider/partner/detail/{partnerId}")
    ResponseMessage<Partner> detail(@PathVariable("partnerId") Integer partnerId);
}