package com.sixkery.basis.security.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sixkery
 * @date 2020/10/27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermissionDO {

    @ApiModelProperty(value = "菜单标题")
    private String title;

    @ApiModelProperty(value = "页面路径/资源链接url")
    private String path;
}
