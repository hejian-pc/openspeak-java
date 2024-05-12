package com.hejmls.mapper;

import com.hejmls.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
    public void insertUser(User user);
}
