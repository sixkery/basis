package com.sixkery.kery.security;

import com.sixkery.kery.mq.MqApplication;
import com.sixkery.kery.mq.controller.MqConsumer;
import com.sixkery.kery.mq.controller.MqProvider;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest(classes = MqApplication.class)
public class MqApplicationTests {

    @Resource
    private MqProvider mqProvider;


    @Resource
    private MqConsumer mqConsumer;

    @Test
    public void contextLoads() {
        mqProvider.sendMessage();
    }

}
