package com.hejmls.mapper;

import com.hejmls.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User login(User user);
    User selectUser(String username);
}
