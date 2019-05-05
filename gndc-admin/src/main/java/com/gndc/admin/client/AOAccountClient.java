package com.gndc.admin.client;

import com.gndc.common.api.ResponseMessage;
import com.gndc.admin.api.admin.account.AOLoginRequest;
import com.gndc.admin.api.admin.account.AOLoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/22
 */
@FeignClient(name = "gndc-core")
public interface AOAccountClient {

    @PostMapping("/admin/account/login")
    ResponseMessage<AOLoginResponse> login(@RequestBody AOLoginRequest request);
}