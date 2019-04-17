package com.gndc.core.controller.open;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSONObject;
import com.gndc.common.api.ResponseMessage;
import com.gndc.core.api.open.OpenDemoRequestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/4/11
 */
@Slf4j
@RestController
@RequestMapping("/open")
public class OpenController {

    @PostMapping("/openDemo")
    public ResponseMessage<Object> helloApi(@Validated @RequestBody OpenDemoRequestMessage openRequest) {
        log.info(JSONObject.toJSONString(openRequest, true));
        ResponseMessage<Object> resposne = new ResponseMessage<>();
        resposne.setData(new JSONObject().fluentPut("partnerId", 123).fluentPut("money", 123423));
        return resposne;
    }

    @PostMapping("/feignProvider")
    public ResponseMessage<JSONObject> feignProvider(@Validated @RequestBody JSONObject body) {
        log.info("body:[{}]", body);
        ResponseMessage<JSONObject> response = new ResponseMessage<>();
        JSONObject json = new JSONObject();
        json.fluentPut("name", RandomUtil.randomString(10))
                .fluentPut("age", RandomUtil.randomInt(20, 25));
        response.setData(json);
        return response;
    }
}
