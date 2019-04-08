package com.gndc.core.controller.admin.sys;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.common.constant.CacheConstant;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.common.PlatformEnum;
import com.gndc.common.enums.common.StatusEnum;
import com.gndc.common.exception.HjException;
import com.gndc.common.utils.PwdUtil;
import com.gndc.core.api.admin.sys.*;
import com.gndc.common.api.ResponseMessage;
import com.gndc.core.mappers.AOAdminListResponseMapping;
import com.gndc.core.mappers.AdminMapping;
import com.gndc.core.model.Admin;
import com.gndc.core.model.Partner;
import com.gndc.core.model.Role;
import com.gndc.core.service.account.AdminService;
import com.gndc.core.service.partner.PartnerService;
import com.gndc.core.service.sys.RoleService;
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
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin/sys/admin")
public class AOAdminController {

    private static final Logger logger = LoggerFactory.getLogger(AOAdminController.class);

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PartnerService partnerService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 添加管理员账号
     * @param request
     * @return
     */
    @PostMapping("/addAdmin")
    public ResponseMessage<Integer> addAdmin(@Validated @RequestBody AOAdminAddRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        String loginName = request.getLoginName();
        Weekend<Admin> weekend = Weekend.of(Admin.class);
        weekend.weekendCriteria()
                .andEqualTo(Admin::getLoginName, loginName)
                .andEqualTo(Admin::getStatus, StatusEnum.NORMAL.getCode());
        Admin originalAdmin = adminService.selectOneByExample(weekend);
        if (ObjectUtil.isNotNull(originalAdmin)) {
            String msg = StrUtil.format("登录名 {} 已经存在", loginName);
            throw new HjException(ResultCode.USER_EXISTS, msg);
        }
        Role role = roleService.selectByPrimaryKey(request.getRoleId());
        if (ObjectUtil.isNull(role)) {
            String msg = StrUtil.format("角色id {} 不存在", request.getRoleId());
            throw new HjException(ResultCode.ROLE_NOT_EXIST, msg);
        }
        String passwordDec = PwdUtil.decrypt(request.getPassword());
        String operateSign = RandomUtil.randomString(6);
        String passwordSign = RandomUtil.randomString(6);
        String md5Password = PwdUtil.passwordGenerate(passwordDec, passwordSign);

        Admin admin = AdminMapping.INSTANCE.convert(request);
        admin.setPasswordSign(passwordSign);
        admin.setOperateSign(operateSign);
        admin.setPassword(md5Password);
        admin.setCreateAdminId(request.getAoAdmin().getId());
        if (PlatformEnum.PARTNER.getCode().equals(request.getPlatform())) {
            //商户后台
            Partner partner = new Partner();
            partner.setName(request.getPartnerName());

            partnerService.insertSelective(partner);

            admin.setPartnerId(partner.getId());
        }
        adminService.insertSelective(admin);
        response.setData(admin.getId());
        return response;
    }

    /**
     * 修改管理员账号
     * @param request
     * @return
     */
    @PostMapping("/modifyAdmin")
    public ResponseMessage<Integer> modifyAdmin(@Validated @RequestBody AOAdminModifyRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        String loginName = request.getLoginName();
        Admin originalAdmin = adminService.selectOneByProperty(Admin::getLoginName, loginName);
        if (ObjectUtil.isNotNull(originalAdmin) && !originalAdmin.getId().equals(request.getId())) {
            String msg = StrUtil.format("登录名 {} 已经存在", loginName);
            throw new HjException(ResultCode.USER_EXISTS, msg);
        }
        Role role = roleService.selectByPrimaryKey(request.getRoleId());
        if (ObjectUtil.isNull(role)) {
            String msg = StrUtil.format("角色id {} 不存在", request.getRoleId());
            throw new HjException(ResultCode.ROLE_NOT_EXIST, msg);
        }

        Admin admin = AdminMapping.INSTANCE.convert(request);
        admin.setUpdateAdminId(request.getAoAdmin().getId());
        if (PlatformEnum.PARTNER.getCode().equals(request.getPlatform())) {
            Partner partner = new Partner();
            partner.setName(request.getPartnerName());

            partnerService.updateByPrimaryKeySelective(partner);

            admin.setPartnerId(partner.getId());
        }
        adminService.updateByPrimaryKeySelective(admin);
        response.setData(admin.getId());
        return response;
    }

    /**
     * 删除管理员账号
     * @param request
     * @return
     */
    @PostMapping("/deleteAdmin")
    public ResponseMessage<Boolean> deleteAdmin(@Validated @RequestBody AOAdminDeleteRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();
        Admin admin = new Admin();
        admin.setId(request.getId());
        admin.setStatus(StatusEnum.DELETE.getCode());
        adminService.updateByPrimaryKeySelective(admin);
        response.setData(true);
        return response;
    }

    /**
     * 获取管理员列表
     * @param request
     * @return
     */
    @PostMapping("/adminList")
    public ResponseMessage<List<AOAdminListResponse>> adminList(@Validated @RequestBody AOAdminListRequest request) {
        ResponseMessage<List<AOAdminListResponse>> response = new ResponseMessage<>();
        PageInfo page = request.getHeader().getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<Admin> admins = adminService.adminList(request);

        List<AOAdminListResponse> adminList = new ArrayList<>(admins.size());
        admins.forEach(admin -> {
            AOAdminListResponse aoAdmin = AOAdminListResponseMapping.INSTANCE.convert(admin);
            Role role = ((Role) redisTemplate.opsForHash().get(CacheConstant.KEY_ALL_ROLE,
                    aoAdmin.getRoleId()));
            aoAdmin.setRoleName(ObjectUtil.isNotNull(role) ? role.getRoleName() : null);
            if (PlatformEnum.PARTNER.getCode().equals(admin.getPlatform())) {
                Partner partner = partnerService.selectByPrimaryKey(admin.getPartnerId());
                aoAdmin.setPartnerName(partner.getName());
            }
            adminList.add(aoAdmin);
        });
        PageInfo<Admin> pageInfo = new PageInfo<>(admins);
        pageInfo.setList(null);
        response.setData(adminList);
        response.setPage(pageInfo);
        return response;
    }

    /**
     * 重置密码
     * @param request
     * @return
     */
    @PostMapping("/resetPwd")
    public ResponseMessage<Boolean> resetPwd(@Validated @RequestBody AOAdminResetPwdRequest request) {
        ResponseMessage<Boolean> response = new ResponseMessage<>();

        String originalPassword = PwdUtil.decrypt(request.getPassword());
        String operateSign = RandomUtil.randomString(6);
        String passwordSign = RandomUtil.randomString(6);
        String md5Password = PwdUtil.passwordGenerate(originalPassword, passwordSign);

        Admin admin = adminService.selectByPrimaryKey(request.getId());

        admin.setPasswordSign(passwordSign);
        admin.setOperateSign(operateSign);
        admin.setPassword(md5Password);
        admin.setUpdateTime(new Date());

        adminService.updateByPrimaryKeySelective(admin);
        response.setData(true);
        return response;
    }

}
