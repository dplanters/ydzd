package com.gndc.demo.client;

import com.alibaba.fastjson.JSONObject;
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
@FeignClient(name = "gndc-core", url = "http://localhost:11000/open/")
public interface OpenClient {

    @PostMapping("/feignProvider")
    ResponseMessage<Object> feignProvider(@Validated @RequestBody JSONObject body);
}
