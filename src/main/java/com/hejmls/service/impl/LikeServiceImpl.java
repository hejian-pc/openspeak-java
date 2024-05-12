package com.hejmls.service.impl;

import com.hejmls.mapper.LikeMapper;
import com.hejmls.pojo.Article;
import com.hejmls.pojo.Likes;
import com.hejmls.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    LikeMapper likeMapper;
    @Override
    public List<Article> selectLikesbyuserId(int userId) {
        List<Article> likesList = likeMapper.selectLikesbyuserId(userId);
        return likesList;
    }

    @Override
    public int insertLikes(Likes likes) {
        likeMapper.insertLikes(likes);
        return 1;
    }

    @Override
    public int selectLiked(Likes likes) {
        int i = likeMapper.selectLiked(likes);
        return i;
    }

    @Override
    public int delectLiked(Likes likes) {
        likeMapper.delectLiked(likes);
        return 0;
    }
}
