package com.mx.springbootproducer.directConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 1.3 添加一个消息发送类（生产者）
 *     将消息发送至默认的交换机且routingKey为notify.payment
 */
@Slf4j
@Component
public class PaymentNotifySender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sender(String msg){
        log.info("notify.payment send message: "+msg);
        rabbitTemplate.convertAndSend("notify.payment", msg);
    }
}
