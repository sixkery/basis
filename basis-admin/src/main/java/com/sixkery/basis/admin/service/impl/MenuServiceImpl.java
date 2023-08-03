package com.sixkery.basis.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sixkery.basis.admin.domain.entity.system.MenuDO;
import com.sixkery.basis.admin.mapper.MenuMapper;
import com.sixkery.basis.admin.service.MenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author sixkery
 * @since 2020-11-27
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuDO> implements MenuService {
    @Resource
    MenuMapper menuMapper;
    int i = 0;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void  add() {
        i = i+1;
        MenuDO menuDO = menuMapper.selectById(1);
        menuDO.setName(String.valueOf(Integer.parseInt(menuDO.getName()) + 1));


        UpdateWrapper<MenuDO> uw = new UpdateWrapper<>();
        uw.lambda().set(MenuDO::getName, menuDO.getName());

        uw.lambda().eq(MenuDO::getId, menuDO.getId());
        menuMapper.update(menuDO, uw);
        System.out.println("uw = " + i);
    }

}
