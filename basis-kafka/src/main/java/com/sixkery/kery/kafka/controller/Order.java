package com.sixkery.kery.kafka.controller;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 模拟订单类
 *
 * @author sixkery
 * @date 2020/10/25
 */
@Data
public class Order {
    /**
     * 订单 ID
     */
    private Long id;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 订单的创建时间
     */
    private LocalDateTime createTime;
}
