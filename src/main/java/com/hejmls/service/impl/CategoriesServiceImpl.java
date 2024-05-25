package com.hejmls.service.impl;

import com.hejmls.mapper.CategoriesMapper;
import com.hejmls.pojo.Article;
import com.hejmls.pojo.Categories;
import com.hejmls.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    CategoriesMapper categoriesMapper;
    @Override
    public List<Categories> selectAll() {
        List<Categories> categories = categoriesMapper.selectAll();
        return categories;
    }

    @Override
    public void insert(Article article) {
        categoriesMapper.insert(article);
    }

    @Override
    public void insertcate(Categories categories) {
        categoriesMapper.insertCate(categories);
    }
}
