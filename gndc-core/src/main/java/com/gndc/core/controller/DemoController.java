package com.gndc.core.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @ResponseBody
    @RequestMapping("/hello")
    public JSONObject hello() {
        return new JSONObject().fluentPut("abc", "def");
    }
}
