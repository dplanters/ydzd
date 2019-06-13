package com.bbjh.open.controller;

import com.bbjh.common.api.ResponseMessage;
import com.bbjh.open.amqp.producer.VaccineChangeProducer;
import com.bbjh.open.api.receive.VaccineChangeRequest;
import com.bbjh.open.dto.VaccineChangeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fwb
 * @date 2019-6-10
 */
@Slf4j
@RestController
@RequestMapping("/vaccine")
@Api(value = "疫苗相关开放接口调用", tags = {"疫苗相关开放接口调用"}, consumes = "application/json")
public class VaccineController {

    @Autowired
    private VaccineChangeProducer vaccineChangeProducer;
    /**
     * 疫苗库存减少开发调用
     */
    @PostMapping("/vaccineChange")
    @ApiOperation(value = "疫苗库存变化调用", notes = "用于疫苗库存变化调用", produces = "application/json")
    public ResponseMessage<Boolean> vaccineChange(@Validated @RequestBody VaccineChangeRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();
        String uid = request.getUid();
        VaccineChangeDTO vaccineChange = new VaccineChangeDTO().setUid(uid);
        vaccineChangeProducer.sendVaccineChange(vaccineChange);
        response.setData(true);
        return response;
    }
}
