package com.hejmls.mapper;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.IPage;
import com.hejmls.enums.UserSex;
import com.hejmls.pojo.User;
import com.hejmls.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;



@SpringBootTest
class UserMapperTest {


    private final UserService userService;

    @Autowired
    private  UserMapper userMapper;

    @Autowired
    UserMapperTest(UserService userService) {
        this.userService = userService;
    }


    @Test
    public void mpMapperTest(){
       // User users = userMapper.selectById(1);
        User user = userService.selectUser("user1");
        System.out.println(user);
    }
    @Test
    public void WrapperTest(){
        // User users = userMapper.selectById(1);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().select(User::getName,User::getEmail).ge(User::getUserId,3);
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.select().select(User::getName,User::getEmail).ge(User::getUserId,3);

    }

    @Test
    public void DiyWrapperTest(){
        // User users = userMapper.selectById(1);

        List<Integer> list = List.of(1,2,3);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.lambda().in(User::getUserId,list);
        userMapper.updateInfo(userQueryWrapper);

    }

    //10.16.6.254

    @Test
    void testPageQuery() {
        // 1.分页查询，new Page()的两个参数分别是：页码、每页大小
        int pageNum = 2,pageSize = 2;
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        Page<User> page = new Page<>(pageNum, pageSize);
        page.addOrder(new OrderItem());
        Page<User> p = userMapper.selectPage(page,userQueryWrapper);

        // 2.总条数
        System.out.println("total = " + p.getTotal());
        // 3.总页数
        System.out.println("pages = " + p.getPages());
        // 4.数据
        List<User> records = p.getRecords();

        records.forEach(System.out::println);
    }
    @Test
    void testInsertUsers() {
        User user = User.builder()
                .username("hhbuku")
                .password("123")
                .sex(UserSex.MALE)
                .email("hhhh@qq.hhh")
                .registrationDate(new Date())
                .build();
        userMapper.insert(user);


    }


}