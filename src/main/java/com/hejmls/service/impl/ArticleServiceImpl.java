package com.hejmls.service.impl;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hejmls.mapper.ArticleMapper;
import com.hejmls.pojo.Article;
import com.hejmls.pojo.DTO.ArticleQueryDTO;
import com.hejmls.pojo.VO.ArticleVO;
import com.hejmls.pojo.VO.PageResult;
import com.hejmls.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<Article> query(ArticleQueryDTO articleQueryDTO) {
        List<Article> list = articleMapper.query(articleQueryDTO);
        return list;
    }


    @Transactional
    public PageResult findArtilceByPage(int pageNum, int pageSize, ArticleQueryDTO articleQueryDTO) {
        PageHelper.startPage(pageNum,pageSize);
        List<ArticleVO> page = articleMapper.findArtilceByPage(articleQueryDTO);

        log.info(String.valueOf(page.size()));

        PageInfo<ArticleVO> pageInfo = new PageInfo<>(page);
        log.info(pageInfo.getPages()+"分页条件"+pageInfo.getPages());
        PageResult pageResult = new PageResult();
        pageResult.setTotal(pageInfo.getPages());

        pageResult.setRecords(pageInfo.getList());
        return pageResult;
    }
}
