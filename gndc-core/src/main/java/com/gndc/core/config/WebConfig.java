package com.gndc.core.config;

import com.gndc.core.interceptor.LoginCheckInterceptor;
import com.gndc.core.interceptor.OpenSourceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Autowired
    private OpenSourceInterceptor openSourceInterceptor;

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(openSourceInterceptor)
                .addPathPatterns("/**")
                .order(1);
        registry.addInterceptor(loginCheckInterceptor)
                .addPathPatterns("/**")
                .order(2);
    }

    @Bean
    public RequestContextListener requestContextListener() {
        return new RequestContextListener();
    }

}
