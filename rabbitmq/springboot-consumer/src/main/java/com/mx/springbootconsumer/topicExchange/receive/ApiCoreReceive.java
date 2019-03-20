package com.mx.springbootconsumer.topicExchange.receive;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 2.2 添加两个消息监听类（消费者）
 *     监听routingKey为api.core的队列消息
 */
@Slf4j
@Component
@RabbitListener(queues = "api.core")
public class ApiCoreReceive {
    @RabbitHandler
    public void user(String msg) {
        log.info("api.core receive message: "+msg);
    }

}
