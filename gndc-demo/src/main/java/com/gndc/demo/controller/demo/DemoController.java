package com.gndc.demo.controller.demo;

import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.open.OpenDemoRequestMessage;
import com.gndc.demo.api.demo.DemoRequest;
import com.gndc.demo.client.OpenDemoClient;
import com.gndc.demo.model.Demo;
import com.gndc.demo.service.demo.DemoService;
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
    public ResponseMessage<Demo> demo(@Validated @RequestBody DemoRequest request) {
        ResponseMessage<Demo> response = new ResponseMessage<>();
        Demo demo = demoService.selectByPrimaryKey(request.getId());
        response.setData(demo);
        return response;
    }

    @PostMapping("/feignDemo")
    public ResponseMessage feignDemo(@RequestBody OpenDemoRequestMessage request) {
        log.info("come in demo");
        ResponseMessage<Object> responseMessage = openDemoClient.openDemo(request);
        return responseMessage;
    }
}
