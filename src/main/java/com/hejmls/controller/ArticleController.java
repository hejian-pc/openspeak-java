package com.hejmls.controller;

import com.hejmls.pojo.Article;
import com.hejmls.pojo.Categories;
import com.hejmls.pojo.DTO.ArticleQueryDTO;
import com.hejmls.pojo.Result;
import com.hejmls.pojo.VO.PageResult;
import com.hejmls.service.ArticleService;
import com.hejmls.service.CategoriesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ArticleController {
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private ArticleService articleService;
    @GetMapping("/categories")
    public Result selectcate(){
        List<Categories> categories = categoriesService.selectAll();
        return Result.success(categories);
    }

    @GetMapping("/pageArticle")
    public Result PageSelect(int pageNum, int pageSize,ArticleQueryDTO articleQueryDTO){
        PageResult pageResult = articleService.findArtilceByPage(pageNum ,pageSize,articleQueryDTO);
        return Result.success(pageResult);

    }

    @PostMapping("/categories")
    public Result insertCate(@RequestBody Categories categories){
        System.out.println("传入的数据："+categories);
        categoriesService.insertcate(categories);
        return Result.success(categories);
    }

    @PostMapping("/article")
    public Result insert(@RequestBody Article article){
        categoriesService.insert(article);
        return Result.success();
    }

    @GetMapping("/query")
    public Result query(ArticleQueryDTO articleQueryDTO){
        log.info("结束日期"+String.valueOf(articleQueryDTO.getEndDate()));
        List<Article> list = articleService.query(articleQueryDTO);
        return Result.success(list);

    }
}
