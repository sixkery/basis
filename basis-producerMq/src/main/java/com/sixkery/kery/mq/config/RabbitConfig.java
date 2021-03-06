package com.sixkery.kery.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitmq 配置
 *
 * @author sixkery
 */
@Configuration
public class RabbitConfig {

    /**
     * 队列
     *
     * @return 队列
     */
    @Bean
    public Queue orderQueue() {
        // durable    是否持久化到磁盘 默认 false
        // exclusive  只能被当前创建的连接使用，连接关闭后队列即被删除 默认 false
        // autoDelete 是否自动删除当没有生产者或者消费者使用此队列，该队列就会被删除 默认 false
        return new Queue("orderQueue", true);
    }

    /**
     * 交换机
     *
     * @return 交换机
     */
    @Bean
    public DirectExchange orderExchange() {

        return new DirectExchange("orderExchange", true, false);
    }

    /**
     * 将队列和交换机绑定
     *
     * @return 绑定
     */
    @Bean
    public Binding bindingConfig() {
        return BindingBuilder.bind(orderQueue()).to(orderExchange()).with("orderRouting");
    }


}
