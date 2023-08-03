package com.sixkery.basis.admin.web.controller;


import com.sixkery.basis.admin.service.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author sixkery
 * @since 2020-11-27
 */
@RestController
@RequestMapping("/system/menu")
public class MenuController {

    @Resource
    private MenuService menuService;

    @GetMapping
    public void concurrence() {
        menuService.add();

    }

}

