package com.gndc.core.controller.admin.sys;

import com.gndc.core.api.admin.sys.AORightAddModifyRequest;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.mappers.RightMapping;
import com.gndc.core.model.Right;
import com.gndc.core.service.sys.RightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/right")
public class AORightController {

    private static final Logger logger = LoggerFactory.getLogger(AORightController.class);

    @Autowired
    private RightService rightService;

    @PostMapping("/addModifyRight")
    public ResponseMessage<Integer> addModifyRole(@Validated @RequestBody AORightAddModifyRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Right right = RightMapping.INSTANCE.convert(request);

        rightService.insertSelective(right);
        response.setData(right.getId());
        return response;
    }
}
