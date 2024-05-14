package com.hejmls.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private int articleId;
    private int userId;
    private int categoryId;
    private String title;
    private String content;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishDate;
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastUpdatedDate;
}
