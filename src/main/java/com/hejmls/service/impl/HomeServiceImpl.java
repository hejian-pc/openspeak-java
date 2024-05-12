package com.hejmls.service.impl;

import com.hejmls.mapper.HomeMapper;
import com.hejmls.pojo.Article;
import com.hejmls.service.HomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeMapper homeMapper;
    @Override
    public List<Article> homeArticle() {
        List<Article> articles = homeMapper.homeArticle();
        return articles;
    }

    @Override
    public List<Article> homeArticlebyarticlesId(int articlesId) {
        List<Article> article = homeMapper.homeArticlebyarticlesId(articlesId);
        return article;
    }

    @Override
    public List<Article> homeArticlebycategoryId(int categoryId) {
        List<Article> article = homeMapper.homeArticlebycategoryId(categoryId);
        return article;
    }
}
