package com.gndc.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.gndc.common.mapper")
@SpringBootApplication(scanBasePackages = {
        "com.gndc.product", "com.gndc.common.config",
        "com.gndc.common.utils", "com.gndc.common.exception",
        "com.gndc.common.advice", "com.gndc.common.aspect",
        "com.gndc.common.interceptor",
        })
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.gndc")
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
