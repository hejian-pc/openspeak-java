package com.hejmls;

import com.github.pagehelper.PageHelper;
import com.hejmls.pojo.Article;
import com.hejmls.pojo.VO.ArticleVO;
import com.hejmls.service.HomeService;
import com.hejmls.service.LikeService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class OpenspeakApplicationTests {

    @Autowired
    HomeService homeService;

    @Autowired
    LikeService likeService;
    //@Test
    public void test(){
        PageHelper.startPage(1,1);
        List<Article> articles = likeService.selectLikesbyuserId(1);
        System.out.println(articles.size());
    }


}
