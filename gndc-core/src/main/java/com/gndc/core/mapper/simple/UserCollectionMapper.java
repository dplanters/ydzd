package com.gndc.core.mapper.simple;

import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.UserCollection;
import com.gndc.core.etc.product.ProductDataExpansion;
import com.gndc.core.etc.user.UserCollectionExt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserCollectionMapper extends MyMapper<UserCollection, Integer> {

    /**
     * @param page
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    List<UserCollectionExt> selectUserCollectionByUserId(@Param("userId") int userId, @Param("page") Page page);

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    long selectUserCollectionByUserIdCount(int userId);

    /**
     * @Description
     * @author <a href="biankongbin8418@adpanshi.com">biankongbin</a>
     */
    List<ProductDataExpansion> selectUserCollectionByUserIdNotOffline(int userId);

}