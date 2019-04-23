package com.gndc.open.client;

import com.gndc.common.api.ResponseMessage;
import com.gndc.open.api.OpenDemoRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/22
 */
@FeignClient(name = "gndc-open")
public interface OpenDemoClient {

    @PostMapping("/open/openDemo")
    ResponseMessage<Object> openDemo(OpenDemoRequest request);
}

