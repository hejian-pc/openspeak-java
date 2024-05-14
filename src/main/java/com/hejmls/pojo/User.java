package com.hejmls.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String name;
    private String username;
    private String password;
    private String email;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registrationDate;
    private String otherInfo;
}
