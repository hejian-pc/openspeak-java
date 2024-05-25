package com.hejmls.mapper;

import com.hejmls.pojo.Article;
import com.hejmls.pojo.VO.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeMapper {
    public List<ArticleVO> homeArticle();
    public List<ArticleVO> homeArticlebyarticlesId(int articlesId);
    public List<ArticleVO> homeArticlebycategoryId(int categoryId);

}
