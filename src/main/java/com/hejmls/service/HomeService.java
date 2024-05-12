package com.hejmls.service;

import com.hejmls.pojo.Article;

import java.util.List;

public interface HomeService {
    public List<Article> homeArticle();
    public List<Article> homeArticlebyarticlesId(int articlesId);
    public List<Article> homeArticlebycategoryId(int categoryId);
}
