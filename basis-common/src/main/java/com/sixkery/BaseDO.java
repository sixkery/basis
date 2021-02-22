package com.sixkery;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 基础
 *
 * @author sixkery
 */
@Data
public class BaseDO {


    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
