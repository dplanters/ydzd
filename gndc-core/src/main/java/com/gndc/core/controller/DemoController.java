package com.gndc.core.controller;

import com.gndc.core.model.Product;
import com.gndc.core.service.simple.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DemoController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ProductService productService;

    @ResponseBody
    @RequestMapping("/hello")
    public Product hello() {
        Product product = productService.selectByPrimaryKey(134);
        return product;
    }
}
