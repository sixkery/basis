package com.sixkery.basis.api.system.service.impl;

import com.sixkery.basis.api.system.entity.Role;
import com.sixkery.basis.api.system.mapper.RoleMapper;
import com.sixkery.basis.api.system.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author sixkery
 * @since 2020-11-27
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
