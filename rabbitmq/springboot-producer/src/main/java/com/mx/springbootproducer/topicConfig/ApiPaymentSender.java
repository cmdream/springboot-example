package com.mx.springbootproducer.topicConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 2.3 添加两个消息发送类（生产者）
 *     添加一个order()方法，发送消息至paymentExchange交换机且routingKey为api.payment.order
 *     添加一个orderQuery()方法，发送消息至paymentExchange交换机且routingKey为api.payment.order.query
 *     添加一个orderDetailQuery()方法，发送消息至paymentExchange交换机且routingKey为api.payment.order.detail.query
 */
@Slf4j
@Component
public class ApiPaymentSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void order(String msg){
        log.info("api.payment.order send message: "+msg);
        rabbitTemplate.convertAndSend("paymentExchange", "api.payment.order", msg);
    }

    public void orderQuery(String msg){
        log.info("api.payment.order.query send message: "+msg);
        rabbitTemplate.convertAndSend("paymentExchange", "api.payment.order.query", msg);
    }

    public void orderDetailQuery(String msg){
        log.info("api.payment.order.detail.query send message: "+msg);
        rabbitTemplate.convertAndSend("paymentExchange", "api.payment.order.detail.query", msg);
    }
}
