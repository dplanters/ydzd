package com.gndc.core.service.simple.impl;

import com.github.pagehelper.PageHelper;
import com.gndc.common.service.impl.BaseServiceImpl;
import com.gndc.core.mapper.simple.ProductMapper;
import com.gndc.core.model.Product;
import com.gndc.core.service.simple.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product, Integer> implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> products() {
        PageHelper.startPage(1, 5);
        List<Product> products = productMapper.selectAll();
        return products;
    }
}
