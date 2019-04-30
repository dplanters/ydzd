package com.gndc.admin.service.product.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.common.mapper.ProductHotMapper;
import com.gndc.common.model.ProductHot;
import com.gndc.admin.service.product.ProductHotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class ProductHotServiceImpl extends BaseServiceImpl<ProductHot, Integer> implements ProductHotService {

    @Resource
    private ProductHotMapper productHotMapper;

}
