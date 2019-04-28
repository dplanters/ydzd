package com.gndc.product.service;


import com.gndc.product.ProductApplication;
import com.gndc.product.dto.ProductListDTO;
import com.gndc.product.mapper.ProductAccessConfigMapper;
import com.gndc.product.model.ProductAccessConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApplication.class)
public class ProductAccessConfigServiceTest {


    @Autowired
    private ProductAccessConfigMapper productAccessConfigMapper;
    @Autowired
    private ProductService productService;

    @Test
    public void insert(){
        ProductAccessConfig productAccessConfig=new ProductAccessConfig();
        productAccessConfig.setProductId(1);
        productAccessConfig.setCreateTime(new Date());
        productAccessConfig.setOperatorId(12);
        productAccessConfigMapper.insertSelective(productAccessConfig);
    }

    @Test
    public void searchTest(){
        List<ProductListDTO> productListDTO = productService.selectProduct(null);
        System.out.println(productListDTO);
    }

}