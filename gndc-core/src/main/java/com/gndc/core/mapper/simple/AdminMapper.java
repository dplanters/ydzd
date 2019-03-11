package com.gndc.core.mapper.simple;

import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.admin.AdminListRequest;
import com.gndc.core.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper extends MyMapper<Admin, Integer> {

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    com.gndc.common.model.Admin selectAdminByLoginName(String loginName);

    /**
     * 管理员分页列表
     *
     * @param admin
     * @param page
     * @return
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    List<com.gndc.common.model.Admin> selectAdminPageList(@Param("admin") com.gndc.common.model.Admin admin,
                                                          @Param("page") Page page, @Param("whereReq") AdminListRequest whereReq);

    /**
     * 管理员总条数
     *
     * @param admin
     * @return
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    long selectAdminCount(@Param("admin") com.gndc.common.model.Admin admin, @Param("whereReq") AdminListRequest whereReq);

    /**
     * 根据角色名查询管理员列表
     *
     * @param roleId
     * @return
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    List<com.gndc.common.model.Admin> selectListByRoleId(int roleId);

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    long updateByIdSelective(com.gndc.common.model.Admin admin);
}