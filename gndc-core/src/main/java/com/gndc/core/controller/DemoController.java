package com.gndc.core.controller;

import com.gndc.core.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class DemoController {


    @ResponseBody
    @RequestMapping("/hello")
    public List<Product> hello() {
//        List<Product> products = productService.products();
        return null;
    }
}
