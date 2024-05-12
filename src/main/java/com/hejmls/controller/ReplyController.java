package com.hejmls.controller;

import com.hejmls.pojo.Replies;
import com.hejmls.pojo.Result;
import com.hejmls.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReplyController {
    @Autowired
    ReplyService replyService;

    @PostMapping("/replies")
    @CrossOrigin(origins = {"http://10.16.105.65:7000", "http://localhost:7000/"})
    public Result insertReplies(@RequestBody Replies replies){
        replyService.insertResult(replies);
        return Result.success(replies);

    }
    @GetMapping("/replies/{articleId}")
    @CrossOrigin(origins = {"http://10.16.105.65:7000", "http://localhost:7000/"})
    public Result listReplies(@PathVariable int articleId){
        List<Replies> replies = replyService.selectResult(articleId);
        return Result.success(replies);

    }
}
