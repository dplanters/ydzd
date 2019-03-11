package com.gndc.core.mapper.simple;

import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.api.admin.RoleListRequest;
import com.gndc.core.model.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper extends MyMapper<Role, Integer> {

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    Role selectRole(Role role);

    /**
     * 根据角色id查询角色名
     *
     * @param roleIds
     * @return
     * @Description
     */
    List<Map<String, Object>> selectRoleNameByRoleIds(List<Integer> roleIds);

    /**
     * 分页显示角色列表
     *
     * @param role
     * @param page
     * @return
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    List<Role> selectRolePageList(@Param("role") Role role, @Param("page") Page page,
                                  @Param("whereReq") RoleListRequest whereReq);

    /**
     * 分页显示角色总条数
     *
     * @param role
     * @param page
     * @return
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    long selectRoleCount(@Param("role") Role role, @Param("whereReq") RoleListRequest whereReq);

    Role selectRoleByEdit(Role role);
}