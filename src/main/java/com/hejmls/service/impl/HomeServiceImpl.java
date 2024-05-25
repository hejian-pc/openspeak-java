package com.hejmls.service.impl;

import com.hejmls.mapper.HomeMapper;
import com.hejmls.pojo.Article;
import com.hejmls.pojo.VO.ArticleVO;
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
    public List<ArticleVO> homeArticle() {
        List<ArticleVO> articles = homeMapper.homeArticle();
        return articles;
    }

    @Override
    public List<ArticleVO> homeArticlebyarticlesId(int articlesId) {
        List<ArticleVO> article = homeMapper.homeArticlebyarticlesId(articlesId);
        return article;
    }

    @Override
    public List<ArticleVO> homeArticlebycategoryId(int categoryId) {
        List<ArticleVO> article = homeMapper.homeArticlebycategoryId(categoryId);
        return article;
    }
}
