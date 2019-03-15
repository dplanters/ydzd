package com.gndc.core.controller.admin.sys;

import com.gndc.core.api.admin.AORoleAddModifyRequest;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.service.sys.RoleService;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/role")
public class AORoleController {

    private static final Logger logger = LoggerFactory.getLogger(AORoleController.class);

    @Autowired
    private RoleService roleService;

    @PostMapping("/addModifyRole")
    public ResponseMessage<Integer> addModifyRole(@Validated @RequestBody AORoleAddModifyRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Integer id = roleService.addRole(request);
        response.setData(id);
        return response;
    }
}
