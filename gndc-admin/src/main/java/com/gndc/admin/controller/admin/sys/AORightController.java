package com.gndc.admin.controller.admin.sys;

import cn.hutool.core.util.StrUtil;
import com.gndc.admin.api.admin.sys.*;
import com.gndc.admin.mappers.RightInfoDTOMapping;
import com.gndc.admin.mappers.RightMapping;
import com.gndc.common.model.Right;
import com.gndc.common.model.RoleRight;
import com.gndc.admin.service.sys.RightService;
import com.gndc.admin.service.sys.RoleRightService;
import com.gndc.admin.util.RightConvertUtil;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.dto.RightInfoDTO;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.exception.HjException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/sys/right")
public class AORightController {

    @Autowired
    private RightMapping rightMapping;

    @Autowired
    private RightService rightService;

    @Autowired
    private RoleRightService roleRightService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RightInfoDTOMapping rightInfoDTOMapping;

    /**
     * 添加权限
     * @param request
     * @return
     */
    @PostMapping("/addRight")
    public ResponseMessage<Integer> addRight(@Validated @RequestBody AORightAddRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Right right = rightMapping.convert(request);
        rightService.insertSelective(right);
        RightInfoDTO rightInfo = rightInfoDTOMapping.convert(right);
        redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_RIGHT, rightInfo.getId(), rightInfo);
        response.setData(right.getId());
        return response;
    }

    /**
     * 修改权限
     * @param request
     * @return
     */
    @PostMapping("/modifyRight")
    public ResponseMessage<Integer> modifyRight(@Validated @RequestBody AORightModifyRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Right right = rightMapping.convert(request);
        rightService.updateByPrimaryKeySelective(right);
        RightInfoDTO rightInfo = rightInfoDTOMapping.convert(right);
        redisTemplate.opsForHash().put(CacheConstant.KEY_ALL_RIGHT, rightInfo.getId(), rightInfo);
        response.setData(right.getId());
        return response;
    }

    /**
     * 获取权限树
     * @param request
     * @return
     */
    @PostMapping("/rightTree")
    public ResponseMessage<RightInfoDTO> rightTree(@Validated @RequestBody AORightTreeRequest request) {
        ResponseMessage<RightInfoDTO> response = new ResponseMessage<>();
        List<Right> rights = rightService.rightsTree((byte)1, request.getPlatform(), 0,
                rightService.rightIds(request.getPlatform()));
        response.setData(RightConvertUtil.convertToRightInfo(rights).get(0));
        return response;
    }

    /**
     * 获取权限详情
     * @param request
     * @return
     */
    @PostMapping("/detail")
    public ResponseMessage<Right> detail(@Validated @RequestBody AORightDetailRequest request) {
        ResponseMessage<Right> response = new ResponseMessage<>();
        Right right = rightService.selectByPrimaryKey(request.getId());
        response.setData(right);
        return response;
    }

    /**
     * 删除权限
     * @param request
     * @return
     */
    @PostMapping("/delete")
    public ResponseMessage<Boolean> delete(@Validated @RequestBody AORightDeleteRequest request) {
        ResponseMessage<Boolean> resposne = new ResponseMessage<>();
        Integer id = request.getId();
        int rightIdCount = roleRightService.selectCountByProperty(RoleRight::getRightId, id);

        if (rightIdCount > 0) {
            String msg = StrUtil.format("权限编号 {} 在使用，请先取消相关角色授权后再进行删除！", id);
            log.warn(msg);
            throw new HjException(ResultCode.RIGHT_IS_USING);
        }

        int superIdCount = rightService.selectCountByProperty(Right::getSuperId, id);

        if (superIdCount> 0) {
            String msg = StrUtil.format("权限编号 {} 存在子权限，请先删除子权限后后再进行删除！", id);
            log.warn(msg);
            throw new HjException(ResultCode.RIGHT_IS_USING);
        }

        boolean success = rightService.deleteByPrimaryKey(id);
        redisTemplate.opsForHash().delete(CacheConstant.KEY_ALL_RIGHT, id);
        resposne.setData(success);
        return resposne;
    }
}
