package com.hejmls.controller;

import com.hejmls.pojo.Article;
import com.hejmls.pojo.Likes;
import com.hejmls.pojo.Result;
import com.hejmls.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LikeController {
    @Autowired
    LikeService likeService;
    @GetMapping("/like/{userId}")

    public Result listLikes(@PathVariable int userId){
        List<Article> likesList =  likeService.selectLikesbyuserId(userId);
        return Result.success(likesList);
    }
    @PostMapping ("/like")

    public Result listLikes(@RequestBody Likes likes){
        likeService.insertLikes(likes);
        return Result.success();
    }
    @PostMapping ("/likes")

    public Result shelectLiked(@RequestBody Likes likes){
        int i = likeService.selectLiked(likes);
        return Result.success(i);
    }
    @DeleteMapping  ("/like")

    public Result delectLiked(@RequestBody Likes likes){
        likeService.delectLiked(likes);
        return Result.success();
    }
}
