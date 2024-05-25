package com.hejmls.mapper;

import com.hejmls.pojo.Article;
import com.hejmls.pojo.Categories;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoriesMapper {
    @Select("select * from categories")
    List<Categories> selectAll();

    void insert(Article article);

    void insertCate(Categories categories);
}
