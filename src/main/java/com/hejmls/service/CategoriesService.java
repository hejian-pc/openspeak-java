package com.hejmls.service;

import com.hejmls.pojo.Article;
import com.hejmls.pojo.Categories;

import java.util.List;

public interface CategoriesService {
    List<Categories> selectAll();

    void insert(Article article);

    void insertcate(Categories categories);
}
