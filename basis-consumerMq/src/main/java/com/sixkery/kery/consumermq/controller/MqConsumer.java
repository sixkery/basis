package com.sixkery.kery.consumermq.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * rabbbitmq 消费者
 *
 * @author sixkery
 * @date 2020/10/25
 */
@Component
@Slf4j
@RabbitListener(queues = "orderQueue")
public class MqConsumer {

    @RabbitHandler
    public void consume(String orderStr) {

        Order order = JSON.parseObject(orderStr, Order.class);
        System.out.println("order = " + order);
    }

}
