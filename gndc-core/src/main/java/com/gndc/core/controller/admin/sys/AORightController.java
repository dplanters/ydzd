package com.gndc.core.controller.admin.sys;

import cn.hutool.core.util.ObjectUtil;
import com.gndc.core.api.admin.sys.AORightAddModifyRequest;
import com.gndc.core.api.admin.sys.AORightTreeRequest;
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

import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping("/admin/sys/right")
public class AORightController {

    private static final Logger logger = LoggerFactory.getLogger(AORightController.class);

    @Autowired
    private RightService rightService;

    @PostMapping("/addModifyRight")
    public ResponseMessage<Integer> addModifyRole(@Validated @RequestBody AORightAddModifyRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Right right = RightMapping.INSTANCE.convert(request);
        if (ObjectUtil.isNull(request.getId())) {
            rightService.insertSelective(right);
        } else {
            rightService.updateByPrimaryKey(right);
        }
        response.setData(right.getId());
        return response;
    }

    @PostMapping("/rightTree")
    public ResponseMessage<Right> addModifyRole(@Validated @RequestBody AORightTreeRequest request) {
        ResponseMessage<Right> response = new ResponseMessage<>();
        List<Right> rights = rightService.rightsTree((byte)1, request.getPlatform(), 0, rightService.rightIds());
        response.setData(rights.get(0));
        return response;
    }

}
