package com.gndc.open.controller;

import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.open.OpenDemoRequestMessage;
import com.gndc.open.model.Open;
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


    @PostMapping("/demo")
    public ResponseMessage<Open> demo(@Validated @RequestBody OpenDemoRequestMessage request) {
        return null;
    }

}
