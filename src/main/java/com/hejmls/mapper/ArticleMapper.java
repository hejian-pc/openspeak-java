package com.hejmls.mapper;



import com.hejmls.pojo.Article;
import com.hejmls.pojo.DTO.ArticleQueryDTO;
import com.hejmls.pojo.VO.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    List<Article> query(ArticleQueryDTO articleQueryDTO);

    List<ArticleVO> findArtilceByPage(ArticleQueryDTO articleQueryDTO);
}
