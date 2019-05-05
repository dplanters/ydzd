package com.gndc.common.mapper;

import com.gndc.common.api.admin.product.productshowconfig.AOProductShowConfigSearchRequest;
import com.gndc.common.dto.ProductShowConfigListDTO;
import com.gndc.common.model.ProductShowConfig;
import com.gndc.common.mybatis.MyMapper;

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