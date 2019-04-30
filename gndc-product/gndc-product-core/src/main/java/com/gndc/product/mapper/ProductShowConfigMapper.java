package com.gndc.product.mapper;

import com.gndc.common.mybatis.MyMapper;
import com.gndc.product.api.admin.product.productshowconfig.AOProductShowConfigSearchRequest;
import com.gndc.product.dto.ProductShowConfigListDTO;
import com.gndc.product.model.ProductShowConfig;

import java.util.List;

public interface ProductShowConfigMapper extends MyMapper<ProductShowConfig,Integer> {

    /**
     * 分页查询
     * @param param
     * @Description
     * @author <a href="liujun8852@adpanshi.com">liujun</a>
     */
    List<ProductShowConfigListDTO> selectProductShowConfigPage(AOProductShowConfigSearchRequest param);
}