package com.hejmls.controller;

import com.hejmls.pojo.Replies;
import com.hejmls.pojo.Result;
import com.hejmls.pojo.VO.RepliesVO;
import com.hejmls.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReplyController {
    @Autowired
    ReplyService replyService;

    @PostMapping("/replies")

    public Result insertReplies(@RequestBody Replies replies){
        replyService.insertResult(replies);
        return Result.success(replies);

    }
    @GetMapping("/replies/{articleId}")

    public Result listReplies(@PathVariable int articleId){
        List<RepliesVO> replies = replyService.selectResult(articleId);
        return Result.success(replies);

    }
}
