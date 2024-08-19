package com.hejmls.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hejmls.enums.UserSex;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("users")
public class User {
    @TableId(type = IdType.AUTO)
    private int userId;
    private String name;
    private String username;
    private String password;
    private String email;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registrationDate;
    private String otherInfo;
    private String image;
    private UserSex sex;
}
