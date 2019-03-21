package com.gndc.core.controller.admin.user;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gndc.core.api.admin.user.AOUserDetailResponse;
import com.gndc.core.api.admin.user.AOUserListRequest;
import com.gndc.core.api.common.ResponseMessage;
import com.gndc.core.model.Admin;
import com.gndc.core.model.User;
import com.gndc.core.service.user.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/user")
public class AOUserController {

    @Autowired
    private UserService userService;

    /**
     * 用户管理-用户列表
     *
     */
    @PostMapping("searchUserList")
    public ResponseMessage<List<User>> searchUserList(@Validated @RequestBody AOUserListRequest request) {

        ResponseMessage<List<User>> response = new ResponseMessage<List<User>>();
        PageInfo page = request.getHeader().getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        Admin admin = request.getAdmin();

        // 用户是否有权限
        Weekend<User> weekend = Weekend.of(User.class);
        weekend.selectProperties("id","phone","regChannel","regTime","lastLoginTime");
        WeekendCriteria<User, Object> criteria = weekend.weekendCriteria();
        criteria.andEqualTo(User::getId,request.getUserId());
        if(StringUtils.isNotBlank(request.getPhone())){
            criteria.andEqualTo(User::getPhone,request.getPhone());
        }
        if(StringUtils.isNotBlank(request.getRegDateBegin())){
            criteria.andGreaterThan(User::getRegTime,request.getRegDateBegin());
        }
        if(StringUtils.isNotBlank(request.getRegDateEnd())){
            criteria.andLessThan(User::getRegTime,request.getRegDateEnd());
        }
        List<User> users = userService.selectByExample(weekend);
        PageInfo<User> pageInfo = new PageInfo<>();
        response.setData(users);
        pageInfo.setList(null);
        response.setPage(pageInfo);
        return response;
    }

    /**
     * 用户管理-用户详情(用户行为)
     */
    @RequestMapping("aoUserEventDetailRequest")
    public ResponseMessage<List<AOUserDetailResponse>> aoUserEventDetailRequest(@Validated @RequestBody AOUserListRequest request) {

        ResponseMessage<List<AOUserDetailResponse>> response = new ResponseMessage<List<AOUserDetailResponse>>();
        PageInfo page = request.getHeader().getPage();
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<AOUserDetailResponse> userDetailResponses = userService.selectUserEventsDetail(request);
        PageInfo<AOUserDetailResponse> pageInfo = new PageInfo<>();
        response.setData(userDetailResponses);
        pageInfo.setList(null);
        response.setPage(pageInfo);
        return response;
    }
}