package com.hejmls.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hejmls.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User login(User user);
    User selectUser(String username);

    void update(User user);

    //@Update("UPDATE users set other_info = 1 ${ew.customSqlSegment}")
    void updateInfo(@Param(Constants.WRAPPER)QueryWrapper<User> userQueryWrapper);


}
