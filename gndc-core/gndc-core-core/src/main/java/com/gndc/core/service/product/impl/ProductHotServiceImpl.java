package com.gndc.core.service.product.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.mapper.simple.ProductHotMapper;
import com.gndc.core.model.ProductHot;
import com.gndc.core.service.product.ProductHotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductHotServiceImpl extends BaseServiceImpl<ProductHot, Integer> implements ProductHotService {

    private static final Logger logger = LoggerFactory.getLogger(ProductHotServiceImpl.class);

    @Resource
    private ProductHotMapper productHotMapper;

}
