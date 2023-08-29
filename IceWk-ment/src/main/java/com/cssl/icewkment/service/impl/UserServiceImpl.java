package com.cssl.icewkment.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cssl.icewkment.entity.User;
import com.cssl.icewkment.mapper.UserMapper;
import com.cssl.icewkment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User GetUserInfoById(Integer id) {
        //根据用户id获取名称信息
        //id是内容发布者id
        return userMapper.selectById(id);
    }


}
