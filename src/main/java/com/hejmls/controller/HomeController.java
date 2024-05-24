package com.hejmls.controller;

import com.hejmls.pojo.Article;
import com.hejmls.pojo.Result;
import com.hejmls.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {
    @Autowired
    HomeService homeService;

    @GetMapping("/home")

    public Result homeArticles() {

        //调用service
        List<Article> articles = homeService.homeArticle();
        return Result.success(articles);
    }

    @GetMapping("/home/{articlesId}")

    public Result homeArticlesbyarticleId(@PathVariable int articlesId) {

        //调用service
        List<Article> article = homeService.homeArticlebyarticlesId(articlesId);
        return Result.success(article);
    }

    @PostMapping("/home/{categoryId}")

    public Result homeArticlesbycategoryId(@PathVariable int categoryId) {

        //调用service
        List<Article> article = homeService.homeArticlebycategoryId(categoryId);
        return Result.success(article);
    }

    @PostMapping("/home")
    public void handlePostRequest() {
        System.out.println("________________________");
        System.out.println("post请求被接收");
        // 处理 POST 请求的逻辑
    }

}
