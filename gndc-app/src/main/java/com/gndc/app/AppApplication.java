package com.gndc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author <a href="jingkaihui@adpanshi.com">jingkaihui</a>
 * @Description
 * @date 2019/5/5
 */
@MapperScan(basePackages = "com.gndc.common.mapper")
@SpringBootApplication(scanBasePackages = {
        "com.gndc.app", "com.gndc.common.config",
        "com.gndc.common.utils", "com.gndc.common.exception",
        "com.gndc.common.advice", "com.gndc.common.aspect",
        "com.gndc.common.interceptor",
        "com.gndc.third"})
@EnableDiscoveryClient
@EnableFeignClients
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

}
