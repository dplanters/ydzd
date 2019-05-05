package com.gndc.demo.controller;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.gndc.common.api.Header;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.model.Demo;
import com.gndc.demo.api.DemoRequest;
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
                .setSign("h7E0wAB9sHymLX+OpAtCAU7n9ecC6+Cw3ZtBCKwiCjPwNFYl1iwGocxcY9EiFRhIuDwJQrB7wc4koX+x1Ll0vLdIEtM+rV7i+BmsqCcoWGRhm2Ga5W6MiiVYJwjWh4BrlngK9GDtA3Hk51VpeFwKP1qUI8xxTwfK6JpZoElgO8s=");
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

}
