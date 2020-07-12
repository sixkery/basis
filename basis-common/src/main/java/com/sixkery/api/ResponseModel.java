package com.sixkery.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author sixkery
 * @date 2020/6/4
 * <p>
 * 全局请求对象返回数据模型
 */
@Data
@ApiModel("全局请求对象返回数据模型")
public class ResponseModel<T> {

    @ApiModelProperty(value = "状态码", position = 1)
    private int code;

    @ApiModelProperty(value = "提示信息", position = 2)
    private String message;

    @ApiModelProperty(value = "返回的数据", position = 3)
    private T data;

    @ApiModelProperty(value = "响应的时间戳", position = 4)
    private long timestamp;

    public ResponseModel(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}

