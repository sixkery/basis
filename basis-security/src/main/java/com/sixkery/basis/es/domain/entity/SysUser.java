package com.sixkery.basis.es.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author sixkery
 * @date 2020/10/27
 */
@Data
@AllArgsConstructor
public class SysUser {

    private Integer id;

    private String name;

    private String password;

}
