package com.bbjh.open.amqp.producer;

import com.bbjh.common.constant.RabbitConstant;
import com.bbjh.open.dto.VaccineChangeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author fwb
 * @date 2019-6-11
 */
@Slf4j
@Component
public class VaccineChangeProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送疫苗库存变化消息
     * @param vaccineChange
     */
    public void sendVaccineChange(VaccineChangeDTO vaccineChange) {
        String uid = vaccineChange.getUid();
        amqpTemplate.convertAndSend(RabbitConstant.QUEUE_VACCINE_CHANGE, vaccineChange);
        log.info("发送疫苗库存消息，;用户Id【{}】", uid);

    }
}
