package com.mx.springbootconsumer.directConfig;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 一、交换机——DirectExchange,DirectExchange是RabbitMQ的默认交换机，直接使用routingKey匹配队列
 * 1.1 添加一个配置类（消费者）
 *     配置一个routingKey为notify.payment的消息队列
 */
@Configuration
public class DirectConfig {
    @Bean
    public Queue paymentNotifyQueue() {
        return new Queue("notify.payment");
    }
}
