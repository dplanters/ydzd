package com.bbjh.open.amqp.consumer;

import cn.hutool.core.util.StrUtil;
import com.bbjh.common.constant.CacheConstant;
import com.bbjh.common.constant.RabbitConstant;
import com.bbjh.open.dto.VaccineChangeDTO;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author fwb
 * @Description 疫苗库存的消息消费者
 * @date 2019-6-11
 */
@Slf4j
@Component
public class VaccineChangeConsumer {

    @Autowired
    private RedissonClient redissonClient;

    /**
     * 疫苗库存变化消息处理
     * @param vaccineChange
     * @param message
     * @param channel
     */
    @RabbitHandler
    @RabbitListener(queues = RabbitConstant.QUEUE_VACCINE_CHANGE)
    public void firstPushChargingProcess(VaccineChangeDTO vaccineChange, Message message, Channel channel) throws IOException {
        String uid = vaccineChange.getUid();
        log.info("接收疫苗库存消息，;用户Id【{}】", uid);
        //声明key对象
        String vaccineChangeLock = StrUtil.format(CacheConstant.KEY_VACCINE_CHANGE_LOCK,
                uid);
        //获取锁对象
        RLock accountBalanceLock = redissonClient.getFairLock(vaccineChangeLock);
        try {
            //加锁，并且设置锁过期时间，防止死锁的产生
            if (!accountBalanceLock.isLocked()) {
                //加锁
                boolean res =accountBalanceLock.tryLock(2,5, TimeUnit.SECONDS);
                if(res){
                    //业务处理

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //释放锁
            accountBalanceLock.unlock();
        }
    }
}
