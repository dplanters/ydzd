package com.gndc.core.controller;

import com.github.pagehelper.PageHelper;
import com.gndc.core.model.Product;
import com.gndc.core.service.simple.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired
    private ProductService productService;

    @ResponseBody
    @RequestMapping("/hello")
    public List<Product> hello() {
        List<Product> products = productService.products();
        return products;
    }
}
