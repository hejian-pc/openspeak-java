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
    @CrossOrigin(origins = {"http://10.16.105.65:7000", "http://localhost:7000/"})
    public Result listLikes(@PathVariable int userId){
        List<Article> likesList =  likeService.selectLikesbyuserId(userId);
        return Result.success(likesList);
    }
    @PostMapping ("/like")
    @CrossOrigin(origins = {"http://10.16.105.65:7000", "http://localhost:7000/"})
    public Result listLikes(@RequestBody Likes likes){
        likeService.insertLikes(likes);
        return Result.success();
    }
    @PostMapping ("/likes")
    @CrossOrigin(origins = {"http://10.16.105.65:7000", "http://localhost:7000/"})
    public Result shelectLiked(@RequestBody Likes likes){
        int i = likeService.selectLiked(likes);
        return Result.success(i);
    }
    @DeleteMapping  ("/like")
    @CrossOrigin(origins = {"http://10.16.105.65:7000", "http://localhost:7000/"})
    public Result delectLiked(@RequestBody Likes likes){
        likeService.delectLiked(likes);
        return Result.success();
    }
}
