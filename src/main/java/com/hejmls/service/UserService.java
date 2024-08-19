package com.hejmls.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hejmls.pojo.User;

public interface UserService extends IService<User> {
    User login(User user);
    User selectUser(String username);

    void update(User user);
}
