package com.hejmls.controller;


import com.hejmls.pojo.Result;
import com.hejmls.pojo.User;
import com.hejmls.service.UserService;
import com.hejmls.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    UserService userService;
    @PostMapping("/login")

    public Result login(@RequestBody User user){

        log.info("用户名+密码：{},{}", user.getUsername(),user.getPassword());

        User u = userService.login(user);
        //登录成功，生成令牌
        if(u!=null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",u.getUserId());
            claims.put("username",u.getUsername());
            claims.put("name",u.getName());

            String jwt = JwtUtils.generateJwt(claims);//包含了当前登录的员工信息
            return Result.success(jwt);
        }
            return Result.error("登录失败");
    }

    @GetMapping("/login/{username}")

    public Result selectUser(@PathVariable String username){
        User u = userService.selectUser(username);
        return Result.success(u);
    }


}
