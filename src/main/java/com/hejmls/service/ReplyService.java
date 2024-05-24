package com.hejmls.service;

import com.hejmls.pojo.Replies;
import com.hejmls.pojo.Result;
import com.hejmls.pojo.VO.RepliesVO;

import java.util.List;

public interface ReplyService {
    public void insertResult(Replies replies);
    public List<RepliesVO> selectResult(int articleId);
}
