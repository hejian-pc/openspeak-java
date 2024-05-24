package com.hejmls.mapper;

import com.hejmls.pojo.Replies;
import com.hejmls.pojo.VO.RepliesVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {
    public void insertResult(Replies replies);
    public List<RepliesVO> selectResult(int articleId);
}
