package com.hejmls.controller;

import com.hejmls.pojo.Article;
import com.hejmls.pojo.Categories;
import com.hejmls.pojo.Result;
import com.hejmls.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    CategoriesService categoriesService;
    @GetMapping("/categories")
    public Result selectcate(){
        List<Categories> categories = categoriesService.selectAll();
        return Result.success(categories);
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
}
