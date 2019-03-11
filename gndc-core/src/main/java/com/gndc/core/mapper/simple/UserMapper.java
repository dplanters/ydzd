package com.gndc.core.mapper.simple;


import com.gndc.common.api.Page;
import com.gndc.common.model.UserExpansion;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.user.AoUserEventDetailRequest;
import com.gndc.core.api.user.UserListRequest;
import com.gndc.core.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper extends MyMapper<User, Integer> {

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    List<UserExpansion> searchUserList(@Param("userWhere") UserListRequest request, @Param("page") Page page);

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    long searchUserListCount(@Param("userWhere") UserListRequest request);

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    long getLossUserCount(@Param("sevenDay") Date date, @Param("now") Date start, @Param("eightDay") Date startTime);

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    UserExpansion selectByUserId(int userId);

    int updatePassword(User user);

    User selectUserByPhone(String phone);

//    List<Map<String, Object>> selectUserEventWithRowbounds(@Param("query") AoUserEventDetailRequest request, PageBounds pageBounds);
}