package com.hejmls.pojo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepliesVO {
    private int replyId;
    private int articleId;
    private int userId;
    private String replyContent;
    private Date replyDate;
    private String name;
}
