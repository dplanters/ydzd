package com.gndc.core.controller.admin.sys;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.api.ResponseMessage;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.common.PlatformEnum;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.exception.HjException;
import com.gndc.core.api.admin.sys.*;
import com.gndc.core.model.Admin;
import com.gndc.core.model.Right;
import com.gndc.core.model.Role;
import com.gndc.core.model.RoleRight;
import com.gndc.core.service.account.AdminService;
import com.gndc.core.service.sys.RightService;
import com.gndc.core.service.sys.RoleRightService;
import com.gndc.core.service.sys.RoleService;
import com.gndc.core.util.RightConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/admin/sys/role")
public class AORoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RightService rightService;

    @Autowired
    private RoleRightService roleRightService;
    
    @Autowired
    private AdminService adminService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 添加角色
     * @param request
     * @return
     */
    @PostMapping("/addRole")
    public ResponseMessage<Integer> addModifyRole(@Validated @RequestBody AORoleAddRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Integer id = roleService.addRole(request);
        response.setData(id);
        return response;
    }

    /**
     * 修改角色
     * @param request
     * @return
     */
    @PostMapping("/modifyRole")
    public ResponseMessage<Integer> addModifyRole(@Validated @RequestBody AORoleModifyRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        Integer id = roleService.modifyRole(request);
        response.setData(id);
        return response;
    }

    /**
     * 删除角色
     * @param request
     * @return
     */
    @PostMapping("/deleteRole")
    public ResponseMessage<Boolean> deleteRole(@Validated @RequestBody AORoleDeleteRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();
        Integer id = request.getId();

        Weekend<Admin> adminWeekend = Weekend.of(Admin.class);
        adminWeekend.weekendCriteria()
                .andEqualTo(Admin::getStatus, StatusEnum.NORMAL.getCode())
                .andEqualTo(Admin::getRoleId, ObjectUtil.defaultIfNull(request.getId(), null));
        //正常用户数量
        int normalAdminCount = adminService.selectCountByExample(adminWeekend);
        if (normalAdminCount > 0) {
            String msg = StrUtil.format("角色编号 {} 存在正常用户，请先删除相关用户", request.getId());
            log.warn(msg);
            throw new HjException(ResultCode.ROLE_HAS_NORMAL_ADMIN);
        }

        List<RoleRight> roleRights = roleRightService.selectByProperty(RoleRight::getRoleId, id);

        List<Integer> roleRightIds = new ArrayList<>(roleRights.size());

        roleRights.forEach(roleRight -> {
            roleRightIds.add(roleRight.getId());
        });

        Weekend<RoleRight> weekend = Weekend.of(RoleRight.class);
        weekend.weekendCriteria()
                .andEqualTo("roleId", id);
        roleRightService.deleteByExample(weekend);
        redisTemplate.opsForHash().delete(CacheConstant.KEY_ALL_ROLE_RIGHT, roleRightIds);

        roleService.deleteByPrimaryKey(id);
        redisTemplate.opsForHash().delete(CacheConstant.KEY_ALL_ROLE, id);
        response.setData(true);
        return response;
    }

    /**
     * 获取角色的权限树
     * @param request
     * @return
     */
    @PostMapping("/roleRightTree")
    public ResponseMessage<AORightTreeResponse> roleRightTree(@Validated @RequestBody AORoleRightTreeRequest request) {
        ResponseMessage<AORightTreeResponse> response = new ResponseMessage<>();
        AORightTreeResponse aoRightTreeResponse = new AORightTreeResponse();

        PlatformEnum fetch = PlatformEnum.fetch(request.getPlatform());

        //自己拥有的权限树
        List<Right> ownRights = null;
        if (ObjectUtil.isNotNull(request.getId())) {
            List<Integer> rightIds = roleRightService.getRightIds(request.getId());
            ownRights = rightService.rightsTree((byte) 1, fetch.getCode(), 0,
                    rightIds).get(0).getChildren();
        }

        //整个权限树
        List<Right> rights = rightService.rightsTree((byte)1, fetch.getCode(), 0,
                rightService.rightIds(request.getPlatform())).get(0).getChildren();

        aoRightTreeResponse.setRightIds(RightConvertUtil.convertOwn(ownRights));
        aoRightTreeResponse.setRightTree(RightConvertUtil.convert(rights));
        response.setData(aoRightTreeResponse);
        return response;
    }

    /**
     * 获取角色列表
     * @param request
     * @return
     */
    @PostMapping("/roleList")
    public ResponseMessage<List<Role>> roleList(@Validated @RequestBody AORoleListRequest request) {
        ResponseMessage<List<Role>> response = new ResponseMessage<>();

        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Role> roles = roleService.selectByProperty(Role::getPlatform, request.getPlatform());

        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        pageInfo.setList(null);
        response.setPage(pageInfo);
        response.setData(roles);
        return response;
    }

    /**
     * 获取角色名列表
     * @param request
     * @return
     */
    @PostMapping("/roleNameList")
    public ResponseMessage<List<Role>> roleList(@Validated @RequestBody AORoleNameListRequest request) {
        ResponseMessage<List<Role>> response = new ResponseMessage<>();
        Weekend<Role> weekend = Weekend.of(Role.class);
        weekend.selectProperties("id", "roleName");
        weekend.weekendCriteria()
                .andEqualTo(Role::getPlatform, request.getPlatform());
        List<Role> roles = roleService.selectByExample(weekend);

        response.setData(roles);
        return response;
    }
}
