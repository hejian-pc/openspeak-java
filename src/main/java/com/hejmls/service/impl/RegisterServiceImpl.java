package com.hejmls.service.impl;

import com.hejmls.mapper.RegisterMapper;
import com.hejmls.pojo.User;
import com.hejmls.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    RegisterMapper registerMapper;
    @Override
    public void insertUser(User user) {
        registerMapper.insertUser(user);
    }
}
