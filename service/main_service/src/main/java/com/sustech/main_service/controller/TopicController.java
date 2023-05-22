package com.sustech.main_service.controller;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Comment;
import com.sustech.main_service.entity.Topic;
import com.sustech.main_service.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "话题接口")
@RestController
@RequestMapping("/topic")
@CrossOrigin
public class TopicController {
    @Autowired
    private TopicService topicService;

    @ApiOperation(value = "增加话题")
    @PostMapping("addTopic")
    public Result addTopic(@RequestBody Topic topic) {
        if (topicService.addTopic(topic))
            return Result.ok().code(200);
        return Result.error();
    }

    @ApiOperation(value = "删除话题")
    @PostMapping("deleteTopic")
    public Result deleteTopic(String id) {
        if (topicService.deleteTopic(id))
            return Result.ok().code(200);
        return Result.error();
    }

    @ApiOperation("评论话题")
    @PostMapping("commentTopic")
    public Result commentTopic(String info, String articleId, String userId, String path) {
        if (topicService.addComment(userId, articleId, info, path))
            return Result.ok().code(200);
        return Result.error();
    }

    @ApiOperation("获取话题评论")
    @PostMapping("getTopicComments")
    public Result getTopicComments(String id) {
        List<Comment> topicCommentList = topicService.getTopicComments(id);
        if (topicCommentList == null) {
            return Result.error().message("Fail to get topic comments");
        }
        return Result.ok().data(Map.of("topicComments", topicCommentList));
    }

}
