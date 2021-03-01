package com.sixkery.kery.mq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * kafka 消费者
 *
 * @author sixkery
 * @date 2020/10/25
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "sixkery", groupId = "group_id")
    public void consume(String message) {
        log.info("消息是：{}", message);

    }

}
