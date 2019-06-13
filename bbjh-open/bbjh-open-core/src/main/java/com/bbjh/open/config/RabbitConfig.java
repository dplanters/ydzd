package com.bbjh.open.config;

import com.bbjh.common.constant.RabbitConstant;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author fwb
 * @Description RabbitMQ 配置
 * @date 2019/5/27
 */
@Configuration
public class RabbitConfig {

    /**
     * 疫苗消库队列
     * @return
     */
    @Bean
    public Queue vaccineSubtract() {
        return new Queue(RabbitConstant.QUEUE_VACCINE_CHANGE);
    }

}
