package com.gndc.core.mapper.simple;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.RoleRight;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleRightMapper extends MyMapper<RoleRight, Integer> {

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    List<RoleRight> selectRightListByRoleId(int id);

    /**
     * 批量新增
     *
     * @param addList
     * @return
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    int batchInsert(List<RoleRight> addList);

    /**
     * 批量删除
     *
     * @param delList
     * @return
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    int batchDelete(List<RoleRight> delList);
}