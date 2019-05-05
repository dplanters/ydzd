package com.gndc.open.controller;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import com.gndc.common.api.ResponseMessage;
import com.gndc.open.api.OpenDemoRequest;
import com.gndc.open.api.UserJudgeRequest;
import com.gndc.open.manager.PartnerManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/open")
public class OpenController {

    @Autowired
    private PartnerManager partnerManager;


    /**
     * 判断用户是否可贷款接口
     * @param request
     * @return
     */
    @PostMapping("/userJudge")
    public ResponseMessage<Object> userJudge(@Validated @RequestBody UserJudgeRequest request) {
//        ResponseMessage<PartnerApi> partnerApiDetail = partnerApiClient.detail(request.getPartnerId(), 1);

        JSONObject params = new JSONObject();
        params.fluentPut("idCard", request.getIdCard())
                .fluentPut("phone", request.getPhone())
                .fluentPut("productId", request.getProductNo());

//        return partnerManager.post(partnerApiDetail.getData().getApiUrl(), params);
        return null;
    }



    @PostMapping("/openDemo")
    public ResponseMessage<Object> demo(@Validated @RequestBody OpenDemoRequest request) {
        ResponseMessage<Object> response = new ResponseMessage<>();
        JSONObject responseBody = new JSONObject()
                .fluentPut("youName", request.getName())
                .fluentPut("myName", RandomUtil.randomString(5));
        response.setData(responseBody);

        return response;
    }

}
