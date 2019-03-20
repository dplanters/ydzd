package com.gndc.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 景凯辉
 * @date 2018/11/9
 * @mail kaihuijing@gmail.com
 */
@MapperScan(basePackages = "com.gndc.core.mapper")
@SpringBootApplication(scanBasePackages = {
        "com.gndc.core", "com.gndc.common.config", "com.gndc.common.utils",
        "com.gndc.third", "com.gndc.common.interceptor"})
public class CoreApplication {


    public static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

}
