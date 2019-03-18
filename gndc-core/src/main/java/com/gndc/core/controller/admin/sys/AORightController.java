package com.gndc.core.controller.admin.sys;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;
import com.gndc.core.api.admin.sys.AORightAddModifyRequest;
import com.gndc.core.api.admin.sys.AORightDeleteRequest;
import com.gndc.core.api.admin.sys.AORightDetailRequest;
import com.gndc.core.api.admin.sys.AORightTreeRequest;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.mappers.RightMapping;
import com.gndc.core.model.Right;
import com.gndc.core.service.sys.RightService;
import com.gndc.core.service.sys.RoleRightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/sys/right")
public class AORightController {

    private static final Logger logger = LoggerFactory.getLogger(AORightController.class);

    @Autowired
    private RightService rightService;

    @Autowired
    private RoleRightService roleRightService;

    @PostMapping("/addModifyRight")
    public ResponseMessage<Integer> addModifyRole(@Validated @RequestBody AORightAddModifyRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Right right = RightMapping.INSTANCE.convert(request);
        if (ObjectUtil.isNull(request.getId())) {
            rightService.insertSelective(right);
        } else {
            rightService.updateByPrimaryKeySelective(right);
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

    @PostMapping("/detail")
    public ResponseMessage<Right> detail(@Validated @RequestBody AORightDetailRequest request) {
        ResponseMessage<Right> resposne = new ResponseMessage<>();
        Right right = rightService.selectByPrimaryKey(request.getId());
        resposne.setData(right);
        return resposne;
    }

    @PostMapping("/delete")
    public ResponseMessage<Boolean> delete(@Validated @RequestBody AORightDeleteRequest request) {
        ResponseMessage<Boolean> resposne = new ResponseMessage<>();
        Integer id = request.getId();
        int rightIdCount = roleRightService.selectCountByProperty("rightId", id);

        if (rightIdCount > 0) {
            String msg = StrUtil.format("权限编号 {} 在使用，请先取消相关角色授权后再进行删除！");
            logger.warn(msg);
            throw new HjException(ResultCode.RIGHT_IS_USING, msg);
        }

        int superIdCount = rightService.selectCountByProperty("superId", request.getId());

        if (superIdCount> 0) {
            String msg = StrUtil.format("权限编号 {} 存在子权限，请先删除子权限后后再进行删除！");
            logger.warn(msg);
            throw new HjException(ResultCode.RIGHT_IS_USING, msg);
        }

        boolean success = rightService.deleteByPrimaryKey(id);
        resposne.setData(success);
        return resposne;
    }
}
