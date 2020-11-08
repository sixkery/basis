package com.sixkery.kery.kafka.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

/**
 * kafka 消息发布者
 *
 * @author sixkery
 * @date 2020/10/25
 */
@Component
@Slf4j
public class KafkaProvider {
    /**
     * 消息 topic
     */
    private static final String TOPIC = "sixkery";

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;


    /**
     * 发送消息
     *
     * @param order 发送消息的内容
     */
    public void sendMessage(Order order) {
        Order newOrder = new Order();
        BeanUtils.copyProperties(order, newOrder);

        // 发送消息，订单类的 json 作为消息体
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(TOPIC, JSONObject.toJSONString(newOrder));

        // 监听回调
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                log.info("消息发送失败！");
            }

            @Override
            public void onSuccess(SendResult<String, String> stringStringSendResult) {
                log.info("消息发送成功！");
            }
        });


    }

}
