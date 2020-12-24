package com.sixkery.basis.api.web.controller;


import com.sixkery.basis.api.web.dto.form.UserFormDTO;
import com.sixkery.basis.api.entity.User;
import com.sixkery.basis.api.service.UserService;
import com.sixkery.exception.ApiException;
import com.sixkery.response.ApiResponses;
import com.sixkery.response.ResultCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    public ApiResponses findAll() {
        return ApiResponses.ok(userService.findAll());
    }


    @ApiOperation(value = "查询单个用户", notes = "根据ID查询单个用户")
    @GetMapping("/{id}")
    public ApiResponses findOne(@PathVariable("id") Long id) {

        User user = userService.getById(id);
        if (user == null) {
            throw new ApiException(ResultCode.USER_NOT_EXIST_EXCEPTION);
        }
        return ApiResponses.ok();
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping("/insert")
    public ApiResponses insert(@RequestBody @Validated List<UserFormDTO> userFormDTOs, BindingResult bindingResult) {


        return ApiResponses.ok();
    }
}

