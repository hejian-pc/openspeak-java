package com.hejmls.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hejmls.pojo.Article;
import com.hejmls.pojo.VO.ArticleVO;

import java.util.List;

public interface HomeService {
    public List<ArticleVO> homeArticle();
    public List<ArticleVO> homeArticlebyarticlesId(int articlesId);
    public List<ArticleVO> homeArticlebycategoryId(int categoryId);
}
