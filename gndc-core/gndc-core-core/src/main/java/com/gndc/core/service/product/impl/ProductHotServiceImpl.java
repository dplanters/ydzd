package com.gndc.core.service.product.impl;

import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.mapper.ProductHotMapper;
import com.gndc.core.model.ProductHot;
import com.gndc.core.service.product.ProductHotService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Slf4j
@Service
public class ProductHotServiceImpl extends BaseServiceImpl<ProductHot, Integer> implements ProductHotService {

    @Resource
    private ProductHotMapper productHotMapper;

}
