package com.hejmls.service.impl;

import com.hejmls.mapper.ReplyMapper;
import com.hejmls.pojo.Replies;
import com.hejmls.pojo.Result;
import com.hejmls.service.ReplyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    ReplyMapper replyMapper;
    @Override
    public void insertResult(Replies replies) {
        replyMapper.insertResult(replies);
    }

    @Override
    public List<Replies> selectResult(int articleId) {
        List<Replies> replies = replyMapper.selectResult(articleId);
        return replies;
    }
}
