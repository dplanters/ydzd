package com.gndc.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 景凯辉
 * @date 2018/11/9
 * @mail kaihuijing@gmail.com
 */
@MapperScan(basePackages = "com.gndc.common.mapper")
@SpringBootApplication(scanBasePackages = {
        "com.gndc.admin", "com.gndc.common.config",
        "com.gndc.common.utils", "com.gndc.common.exception",
        "com.gndc.common.advice", "com.gndc.common.aspect",
        "com.gndc.common.interceptor",
        "com.gndc.third"})
@EnableDiscoveryClient
@EnableFeignClients
public class AdminApplication {


    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
