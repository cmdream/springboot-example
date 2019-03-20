package com.mx.springbootconsumer.topicExchange.receive;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 2.2 添加两个消息监听类（消费者）
 *     监听routingKey为api.payment的队列消息
 */
@Slf4j
@Component
public class ApiPaymentReceive {
    @RabbitHandler
    @RabbitListener(queues = "api.payment")
    public void order(String msg) {
        log.info("api.payment.order receive message: "+msg);
    }
}
