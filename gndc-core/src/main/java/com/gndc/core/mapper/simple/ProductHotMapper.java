package com.gndc.core.mapper.simple;

import com.gndc.common.api.Page;
import com.gndc.common.mybatis.MyMapper;
import com.gndc.core.model.ProductHot;
import com.gndc.core.etc.product.ExProductHot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductHotMapper extends MyMapper<ProductHot, Integer> {
    /**
     * @param page
     * @return
     * @Description 热推产品列表
     * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
     */
    List<ExProductHot> selectProductHotPageList(@Param("record") ProductHot record, @Param("page") Page page);

    /**
     * @return
     * @Description 记录数量
     * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
     */
    long selectProductHotCount(@Param("record") ProductHot record);

    /**
     * @return
     * @Description 删除热推产品
     * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
     */
    int deleteByProductId(Integer id);

    /**
     * @return
     * @Description 热推产品上下线
     * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
     */
    int updateByProductId(ProductHot record);

    /**
     * @return
     * @Description 热推产品删除后, 位置依次上升(position - 1)
     * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
     */
    int updateUpPosition(int position);

    /**
     * @return
     * @Description 热推产品新增后, 位置依次下降(position + 1)
     * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
     */
    int updateDownPosition(int position);

    /**
     * @return
     * @Description 根据产品名查询产品
     * @author <a href="litianwei8504@adpanshi.com">litianwei</a>
     */
    ProductHot selectProductByName(String name);

    ProductHot selectByPosition(int position);
}