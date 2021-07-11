package com.sixkery.basis.admin.service.impl;

import com.sixkery.basis.admin.entity.system.MenuDO;
import com.sixkery.basis.admin.mapper.MenuMapper;
import com.sixkery.basis.admin.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
