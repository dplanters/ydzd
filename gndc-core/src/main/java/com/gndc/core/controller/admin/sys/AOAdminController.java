package com.gndc.core.controller.admin.sys;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.gndc.common.enums.ResultCode;
import com.gndc.common.enums.admin.AdminLevelEnum;
import com.gndc.common.exception.HjException;
import com.gndc.common.utils.PasswordUtil;
import com.gndc.common.utils.PwdUtil;
import com.gndc.core.api.admin.sys.AOAdminAddModifyRequest;
import com.gndc.core.api.common.ResponseMessage;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/sys")
public class AOAdminController {

    private static final Logger logger = LoggerFactory.getLogger(AOAdminController.class);

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PartnerService partnerService;

    @PostMapping("/adminAddModify")
    public ResponseMessage<Integer> adminAddModify(@Validated @RequestBody AOAdminAddModifyRequest request) {
        ResponseMessage<Integer> response = new ResponseMessage<>();
        String loginName = request.getLoginName();
        Admin originalAdmin = adminService.selectOneByProperty("loginName", loginName);
        if (ObjectUtil.isNotNull(originalAdmin)) {
            String msg = StrUtil.format("登录名 {} 已经存在", loginName);
            throw new HjException(ResultCode.USER_EXISTS, msg);
        }
        Role role = roleService.selectByPrimaryKey(request.getRoleId());
        if (ObjectUtil.isNull(role)) {
            String msg = StrUtil.format("角色id {} 不存在", request.getRoleId());
            throw new HjException(ResultCode.ROLE_NOTEXISTS, msg);
        }
        String passwordDec = PwdUtil.decryptRSA(request.getPassword());
        String operateSign = RandomUtil.randomString(6);
        String passwordSign = RandomUtil.randomString(6);
        String md5Password = PasswordUtil.getPassword(passwordDec, passwordSign);

        Admin admin = AdminMapping.INSTANCE.convert(request);
        admin.setPasswordSign(passwordSign);
        admin.setOperateSign(operateSign);
        admin.setPassword(md5Password);
        if (AdminLevelEnum.PARTNER_ADMIN.getCode() == request.getLevel()) {
            Partner partner = new Partner();
            partner.setName(request.getPartnerName());

            partnerService.insertSelective(partner);

            admin.setPartnerId(partner.getId());
        }
        adminService.insertSelective(admin);
        response.setData(admin.getId());
        return response;
    }
}
