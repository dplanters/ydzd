package com.gndc.admin.controller.partner.product;

import com.gndc.admin.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/partner/product")
public class APProductController {

    @Autowired
    private ProductService productService;

}
