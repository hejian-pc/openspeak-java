package com.hejmls.service;

import com.hejmls.pojo.Replies;
import com.hejmls.pojo.Result;

import java.util.List;

public interface ReplyService {
    public void insertResult(Replies replies);
    public List<Replies> selectResult(int articleId);
}
