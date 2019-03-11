/**************************************************************************
 * Copyright (c) 2013-2023  浙江盘石信息技术股份有限公司
 * All rights reserved.
 *
 * 项目名称： 互金网络平台
 * 版权说明：本软件属浙江盘石信息技术股份有限公司所有，在未获浙江盘石信息技术股份有限公司正式授权情况下，
 *          任何企业和个人，不能获取、阅读、安装、传播本软件涉及的任何受知识产权保护的内容。   
 ***************************************************************************/
package com.gndc.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
 * @version V1.0.1
 * @Description redis缓存配置封装
 * @date 2018年1月25日 上午9:57:22
 */
@Configuration
@PropertySource(value = "classpath:/redis.properties")
public class JedisPoolConfigration {
    @Value("${spring.redis.pool.max-idle}")
    private String maxIdle;

    @Value("${spring.redis.pool.max-active}")
    private String maxActive;

    @Value("${spring.redis.pool.max-wait}")
    private String maxWait;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.database}")
    private int database;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String password;

    @Bean(name = "jedisPoolConfig")
    public JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(Integer.parseInt(maxIdle));
        // config.setMax
        config.setMaxWaitMillis(Integer.parseInt(maxWait));
        return new JedisPoolConfig();
    }

    @Bean(name = "jedisConnectionFactory")
    public JedisConnectionFactory getJedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(host);
        factory.setPort(Integer.parseInt(port));
        factory.setPassword(password);
        factory.setDatabase(database);
        factory.setPoolConfig(getJedisPoolConfig());
        return factory;
    }

    /**
     * @return
     * @Description
     * @author <a href="changjunhui8173@adpanshi.com">changjunhui</a>
     */
    @Bean(name = "redisTemplate")
    public StringRedisTemplate getStringRedisTemplate() {
        StringRedisTemplate redisTemplate = new StringRedisTemplate();

        redisTemplate.setConnectionFactory(getJedisConnectionFactory());
        return redisTemplate;
    }
}
