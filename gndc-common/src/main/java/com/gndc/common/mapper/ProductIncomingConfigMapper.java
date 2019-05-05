package com.gndc.common.mapper;

import com.gndc.common.api.admin.product.productincomingconfig.AOProductIncomingConfigSearchRequest;
import com.gndc.common.dto.ProductIncomingConfigListDTO;
import com.gndc.common.model.ProductIncomingConfig;
import com.gndc.common.mybatis.MyMapper;

import java.util.List;

public interface ProductIncomingConfigMapper extends MyMapper<ProductIncomingConfig,Integer> {

    /**
     * 分页列表查询
     * @Description
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    List<ProductIncomingConfigListDTO> selectProductIncomingConfigPage(AOProductIncomingConfigSearchRequest param);

    /**
     * count当天老客进件
     * @param productId 产品id
     * @Description
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    Integer countSameDayOldGuestsOrder(Integer productId);
    /**
     * count当天新客进件
     * @param productId 产品id
     * @Description
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    Integer countSameDayNewGuestsOrder(Integer productId);

    /**
     * 新客进件
     * @param productId 产品id
     * @Description
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    Integer countNewGuests(Integer productId);
    /**
     * 老客进件
     * @param productId 产品id
     * @Description
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    Integer countOldGuests(Integer productId);
}