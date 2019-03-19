package com.gndc.core.controller.admin.sys;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.enums.right.RightPlatformEnum;
import com.gndc.core.api.admin.sys.*;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.model.Right;
import com.gndc.core.model.Role;
import com.gndc.core.service.sys.RightService;
import com.gndc.core.service.sys.RoleRightService;
import com.gndc.core.service.sys.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/sys/role")
public class AORoleController {

    private static final Logger logger = LoggerFactory.getLogger(AORoleController.class);

    @Autowired
    private RoleService roleService;

    @Autowired
    private RightService rightService;

    @Autowired
    private RoleRightService roleRightService;

    @PostMapping("/addRole")
    public ResponseMessage<Integer> addModifyRole(@Validated @RequestBody AORoleAddRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Integer id = roleService.addRole(request);
        response.setData(id);
        return response;
    }

    @PostMapping("/modifyRole")
    public ResponseMessage<Integer> addModifyRole(@Validated @RequestBody AORoleModifyRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Integer id = roleService.modifyRole(request);
        response.setData(id);
        return response;
    }

    @PostMapping("/deleteRole")
    public ResponseMessage<Boolean> deleteRole(@Validated @RequestBody AORoleDeleteRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();
        roleService.deleteByPrimaryKey(request.getId());
        response.setData(true);
        return response;
    }

    @PostMapping("/roleRightTree")
    public ResponseMessage<AORightTreeResponse> roleRightTree(@Validated @RequestBody AORoleRightTreeRequest request) {
        ResponseMessage<AORightTreeResponse> response = new ResponseMessage<>();
        AORightTreeResponse aoRightTreeResponse = new AORightTreeResponse();

        List<Integer> rightIds = roleRightService.getRightIds(request.getId());

        RightPlatformEnum fetch = RightPlatformEnum.fetch(request.getPlatform());

        //自己拥有的权限树
        List<Right> ownRights = rightService.rightsTree((byte)1, fetch.getCode(), 0,
                rightIds).get(0).getChildren();

        //整个权限树
        List<Right> rights = rightService.rightsTree((byte)1, fetch.getCode(), 0,
                rightService.rightIds(request.getPlatform())).get(0).getChildren();

        aoRightTreeResponse.setRightIds(convertOwn(ownRights));
        aoRightTreeResponse.setRightTree(convert(rights));
        response.setData(aoRightTreeResponse);
        return response;
    }

    private List<JSONObject> convert(List<Right> rights) {
        if (CollUtil.isEmpty(rights)) {
            return null;
        } else {
            List<JSONObject> rightsTree = new ArrayList<>();
            for (int i = 0; i < rights.size(); i++) {
                Right right = rights.get(i);
                List<JSONObject> convert = convert(right.getChildren());
                rightsTree.add(new JSONObject()
                        .fluentPut("key", right.getId())
                        .fluentPut("title", right.getRightName())
                        .fluentPut("children", convert));
            }
            return rightsTree;
        }
    }

    private List<JSONObject> convertOwn(List<Right> rights) {
        if (CollUtil.isEmpty(rights)) {
            return null;
        } else {
            List<JSONObject> rightsTree = new ArrayList<>();
            for (int i = 0; i < rights.size(); i++) {
                Right right = rights.get(i);
                List<JSONObject> convert = convertOwn(right.getChildren());
                rightsTree.add(new JSONObject()
                        .fluentPut("id", right.getId())
                        .fluentPut("level", right.getRightLevel())
                        .fluentPut("children", convert));
            }
            return rightsTree;
        }
    }

    @PostMapping("/roleList")
    public ResponseMessage<List<Role>> roleList(@Validated @RequestBody AORoleListRequest request) {
        ResponseMessage<List<Role>> response = new ResponseMessage<>();

        PageInfo page = request.getHeader().getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Role> roles = roleService.selectAll();

        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        pageInfo.setList(null);
        response.setPage(pageInfo);
        response.setData(roles);
        return response;
    }
}
