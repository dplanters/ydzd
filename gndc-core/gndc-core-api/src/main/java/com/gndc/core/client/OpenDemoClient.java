package com.gndc.core.client;

import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.open.OpenDemoRequestMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/22
 */
@FeignClient(name = "gndc-core")
public interface OpenDemoClient {

    @PostMapping("/open/openDemo")
    ResponseMessage<Object> openDemo(OpenDemoRequestMessage request);
}

