package com.sixkery.kery.consumermq.controller;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 模拟订单类
 *
 * @author sixkery
 * @date 2020/10/25
 */
@Data
public class Order implements Serializable {
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
