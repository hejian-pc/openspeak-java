package com.hejmls.pojo.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleVO {
    private int articleId;
    private int userId;
    private int categoryId;
    private String title;
    private String content;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishDate;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdatedDate;
    private String name;
    private int likes;
    private int replies;
}
