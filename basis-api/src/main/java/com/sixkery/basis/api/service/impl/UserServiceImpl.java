package com.sixkery.basis.api.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.sixkery.basis.api.entity.UserDO;
import com.sixkery.basis.api.mapper.UserMapper;
import com.sixkery.basis.api.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author sixkery
 * @since 2020-11-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public PageInfo<UserDO> findAll() {
        PageMethod.startPage(0, 8);
        QueryWrapper<UserDO> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("nickName", "zhangyu");
        List<UserDO> rstList = userMapper.selectList(objectQueryWrapper);

        return new PageInfo<>(rstList);


    }
}
