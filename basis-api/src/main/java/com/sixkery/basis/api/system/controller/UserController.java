package com.sixkery.basis.api.system.controller;


import com.sixkery.basis.api.system.service.UserService;
import com.sixkery.common.response.ApiResponses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author sixkery
 * @since 2020-11-27
 */
@Api(value = "用户管理")
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "查询所有用户信息")
    @GetMapping("/findAll")
    public ApiResponses findAll() {
        return ApiResponses.ok(userService.list());
    }
}

