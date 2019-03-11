package com.gndc.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 景凯辉
 * @date 2018/11/9
 * @mail kaihuijing@gmail.com
 */
@EnableDiscoveryClient
@MapperScan(basePackages = "com.gndc.core.mapper")
@SpringBootApplication(scanBasePackages = {"com.gndc.core", "com.gndc.common.config"})
public class CoreApplication {


    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

}
