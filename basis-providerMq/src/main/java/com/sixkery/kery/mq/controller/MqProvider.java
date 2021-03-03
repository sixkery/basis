package com.sixkery.kery.mq.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * kafka 消息发布者
 *
 * @author sixkery
 * @date 2020/10/25
 */
@Slf4j
@Service
public class MqProvider {

    @Resource
    private RabbitTemplate rabbitTemplate;


    /**
     * 发送消息
     */
    public void sendMessage() {
        Order order = new Order();
        order.setId(1L);
        order.setOrderNo("1");
        order.setCreateTime(LocalDateTime.now());
        String orderStr = JSON.toJSONString(order);
        rabbitTemplate.convertAndSend("orderExchange", "orderRouting", orderStr);


    }

}
