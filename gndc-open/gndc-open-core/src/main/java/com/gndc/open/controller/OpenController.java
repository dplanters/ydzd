package com.gndc.open.controller;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import com.gndc.common.api.ResponseMessage;
import com.gndc.open.api.OpenDemoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/open")
public class OpenController {


    @PostMapping("/openDemo")
    public ResponseMessage<Object> demo(@Validated @RequestBody OpenDemoRequest request) {
        ResponseMessage<Object> response = new ResponseMessage<>();
        response.setData(new JSONObject()
                .fluentPut("youName", request.getName())
                .fluentPut("myName", RandomUtil.randomString(5)));
        return response;
    }

}
