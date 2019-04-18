package com.gndc.demo.client;

import com.gndc.common.api.RequestMessage;
import com.gndc.common.api.ResponseMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/17
 */
@FeignClient(name = "gndc-core")
public interface OpenClient {

    @PostMapping("/open/feignProvider")
    ResponseMessage<Object> feignProvider(@Validated @RequestBody RequestMessage request);
}
