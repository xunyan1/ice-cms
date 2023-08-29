package com.cssl.icewkment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cssl.icewkment.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService extends IService<User> {

    //根据id获取用户信息
    User GetUserInfoById(Integer id);

}
