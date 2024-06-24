package com.hejmls.service.impl;

import com.hejmls.mapper.UserMapper;
import com.hejmls.pojo.User;
import com.hejmls.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User login(User user) {
        User u = userMapper.login(user);
        return u;
    }

    @Override
    public User selectUser(String username) {
        User u = userMapper.selectUser(username);
        return u;
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }
}
