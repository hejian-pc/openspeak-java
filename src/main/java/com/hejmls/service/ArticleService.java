package com.hejmls.service;

import com.hejmls.pojo.Article;
import com.hejmls.pojo.DTO.ArticleQueryDTO;
import com.hejmls.pojo.VO.PageResult;

import java.util.List;

public interface ArticleService {
    List<Article> query(ArticleQueryDTO articleQueryDTO);

    PageResult findArtilceByPage(int pageNum, int pageSize, ArticleQueryDTO articleQueryDTO);
}
