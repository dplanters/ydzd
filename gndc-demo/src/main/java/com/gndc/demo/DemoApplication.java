package com.gndc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 景凯辉
 * @date 2018/11/9
 * @mail kaihuijing@gmail.com
 */
@MapperScan(basePackages = "com.gndc.demo.mapper")
@SpringBootApplication(scanBasePackages = { "com.gndc.demo", "com.gndc.common.config", "com.gndc.common.utils",
		"com.gndc.common.exception", "com.gndc.common.advice", "com.gndc.common.aspect",
		"com.gndc.common.interceptor", })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
