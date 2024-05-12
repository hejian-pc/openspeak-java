package com.hejmls.service;

import com.hejmls.pojo.User;

public interface UserService {
    User login(User user);
    User selectUser(String username);
}
