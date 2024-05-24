package com.hejmls.controller;

import com.hejmls.pojo.Result;
import com.hejmls.pojo.User;
import com.hejmls.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @PostMapping("/register")

    public Result register(@RequestBody User user){
        registerService.insertUser(user);
        return Result.success();
    }

}
