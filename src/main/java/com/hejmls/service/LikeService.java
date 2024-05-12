package com.hejmls.service;

import com.hejmls.pojo.Article;
import com.hejmls.pojo.Likes;

import java.util.List;

public interface LikeService {
    public List<Article> selectLikesbyuserId(int userId);
    public int insertLikes(Likes likes);
    public int selectLiked(Likes likes);
    public int delectLiked(Likes likes);
}
