package com.gndc.demo.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.gndc.common.api.Header;
import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.admin.account.AOLoginRequest;
import com.gndc.core.api.admin.account.AOLoginResponse;
import com.gndc.core.client.AOAccountClient;
import com.gndc.demo.api.DemoRequest;
import com.gndc.demo.model.Demo;
import com.gndc.demo.service.demo.DemoService;
import com.gndc.open.api.OpenDemoRequest;
import com.gndc.open.client.OpenDemoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @Autowired
    private OpenDemoClient openDemoClient;

    @Autowired
    private AOAccountClient aoAccountClient;

    @PostMapping("/demo")
    public ResponseMessage<Object> demo(@Validated @RequestBody DemoRequest request) {
        ResponseMessage<Object> response = new ResponseMessage<>();
        Demo demo = demoService.selectByPrimaryKey(request.getId());
        OpenDemoRequest openDemoRequest = new OpenDemoRequest();
        openDemoRequest.setName("I'm Demo");
        Header header = new Header().setDeviceType("5")
                .setLocale("vn")
                .setAlgorithm("MD5withRSA")
                .setTimestamp(DateUtil.date(1555296403313L))
                .setSign("LevaQQadJKyVze3VmfpE0tT5fmWyFcWHHeSw8YjT4r/KUalU1paZmWrcBuxvATae0nIky1Bc8r1qw7cnXGYYchhVcgb" +
                        "//joYwiHa21QLBUHAVIyLDCngX1g4uhVksbLpQttgLzGUzF5rQjdH8Ju+fR3pROuFh7hnfjzvCboqJCI=");
        openDemoRequest.setHeader(header);
        openDemoRequest.setAppId(1000011110);
        openDemoRequest.setName("张三");
        openDemoRequest.setRandomStr("s8cf5fzja5");

        ResponseMessage<Object> openDemoResponse = openDemoClient.openDemo(openDemoRequest);
        response.setData(new JSONObject()
                .fluentPut("demoData", demo)
                .fluentPut("openDemoData", openDemoResponse));
        return response;
    }

    @PostMapping("/login")
    ResponseMessage<Object> login(@Validated @RequestBody AOLoginRequest request) {
        ResponseMessage<Object> response = new ResponseMessage<>();
        log.info("调用登录服务");
        ResponseMessage<AOLoginResponse> login = aoAccountClient.login(request);
        response.setData(new JSONObject().fluentPut("hello", "feign").fluentPut("loginResponse", login));
        return response;
    }
}
