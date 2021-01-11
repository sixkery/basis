package com.sixkery.basis.api.web.controller;


import com.github.pagehelper.PageInfo;
import com.sixkery.basis.api.entity.User;
import com.sixkery.basis.api.service.UserService;
import com.sixkery.basis.api.web.dto.form.UserDTO;
import com.sixkery.basis.api.web.dto.form.UserFormDTO;
import com.sixkery.response.ApiResponses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author sixkery
 * @since 2020-11-27
 */
@Api(value = "系统用户模块", tags = "系统用户接口")
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户列表", notes = "查询所有用户信息")
    @GetMapping("/findAll")
    public ApiResponses<PageInfo<User>> findAll() {
        return ApiResponses.ok(userService.findAll());
    }


    @ApiOperation(value = "查询单个用户", notes = "根据ID查询单个用户")
    @GetMapping("/{id}")
    public ApiResponses findOne(@PathVariable("id") Long id) {

        User user = userService.getById(id);
        UserDTO userDto = new UserDTO();
        BeanUtils.copyProperties(user, userDto);
        return ApiResponses.ok(userDto);
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping("/insert")
    public ApiResponses insert(@RequestBody UserFormDTO userForm) {

        return ApiResponses.ok();
    }
}

