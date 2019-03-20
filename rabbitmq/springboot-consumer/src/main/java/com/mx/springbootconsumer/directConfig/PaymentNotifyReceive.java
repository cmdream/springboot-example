package com.mx.springbootconsumer.directConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 1.2 添加一个消息监听类（消费者）
 *     监听routingKey为notify.payment的队列消息
 */
@Slf4j
@Component
@RabbitListener(queues = "notify.payment")
public class PaymentNotifyReceive {
    @RabbitHandler
    public void receive(String msg) {
        log.info("notify.payment receive message: "+msg);
    }
}
