package com.hejmls.mapper;

import com.hejmls.pojo.Article;
import com.hejmls.pojo.Likes;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {
    public List<Article> selectLikesbyuserId(int userId);
    public int insertLikes(Likes likes);
    public int selectLiked(Likes likes);
    public int delectLiked(Likes likes);
}
