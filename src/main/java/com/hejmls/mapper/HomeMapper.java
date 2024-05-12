package com.hejmls.mapper;

import com.hejmls.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper {
    public List<Article> homeArticle();
    public List<Article> homeArticlebyarticlesId(int articlesId);
    public List<Article> homeArticlebycategoryId(int categoryId);

}
