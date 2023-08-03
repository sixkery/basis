package com.sixkery.basis.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sixkery.basis.admin.domain.entity.system.MenuDO;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author sixkery
 * @since 2020-11-27
 */
public interface MenuService extends IService<MenuDO> {


    void add();

}
