package com.gndc.core.service.simple;

import com.gndc.common.service.BaseService;
import com.gndc.core.model.Product;

import java.util.List;

public interface ProductService extends BaseService<Product, Integer>{

    List<Product> products();

}
