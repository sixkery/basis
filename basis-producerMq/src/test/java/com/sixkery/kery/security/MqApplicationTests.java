package com.sixkery.kery.security;

import com.rabbitmq.client.*;
import com.sixkery.kery.mq.MqApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootTest(classes = MqApplication.class)
public class MqApplicationTests {

    /**
     * 第一种模型 hello world
     * 生产消息
     *
     * @throws IOException      io 异常
     * @throws TimeoutException 超时异常
     */
    @Test
    void sendMessage() throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 连接 rabbitmq 的主机
        connectionFactory.setHost("localhost");
        // 端口号
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        // 获取连接对象
        Connection connection = connectionFactory.newConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        // 通道绑定消息队列
        // 参数 1: 队列名称 如果队列不存在自动创建
        // 参数 2: 用来定义队列特性是否要持久化 true 持久化队列 false 不持久化
        // 参数 3: exclusive 是否独占队列  true 独占队列 false  不独占
        // 参数 4: autoDelete: 是否在消费完成后自动删除队列  true 自动删除  false 不自动删除
        // 参数 5: 额外附加参数
        channel.queueDeclare("order", true, false, false, null);

        // 发布消息
        // 参数1: 交换机名称 参数2: 队列名称  参数3: 传递消息额外设置  参数4: 消息的具体内容
        channel.basicPublish("", "order", null, "hello rabbitmq".getBytes());

        // 关闭连接
        channel.close();
        connection.close();
    }

    /**
     * 消费消息
     *
     * @throws IOException      io 异常
     * @throws TimeoutException 超时异常
     */
    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        // 连接 rabbitmq 的主机
        connectionFactory.setHost("localhost");
        // 端口号
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        // 获取连接对象
        Connection connection = connectionFactory.newConnection();
        // 创建通道
        Channel channel = connection.createChannel();
        // 通道绑定消息队列
        // 参数 1: 队列名称 如果队列不存在自动创建
        // 参数 2: 用来定义队列特性是否要持久化 true 持久化队列 false 不持久化
        // 参数 3: exclusive 是否独占队列  true 独占队列 false  不独占
        // 参数 4: autoDelete: 是否在消费完成后自动删除队列  true 自动删除  false 不自动删除
        // 参数 5: 额外附加参数
        channel.queueDeclare("order", true, false, false, null);

        // 发布消息
        // 参数 1: 交换机名称 参数 2: 消息的自动确认机制 参数 3：消费时的回调接口
        channel.basicConsume("order", new DefaultConsumer(channel) {
            // 参数 1: 消息的标签 参数 4: 消息队列中取出的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消息内容 = " + new String(body));
            }
        });
    }


}
