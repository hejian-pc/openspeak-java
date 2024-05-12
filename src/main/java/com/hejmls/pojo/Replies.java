package com.hejmls.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Replies {
    private int replyId;
    private int articleId;
    private int userId;
    private String replyContent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date replyDate;
}
