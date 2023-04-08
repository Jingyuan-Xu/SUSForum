package com.sustech.topic_service.controller;

import com.sustech.topic_service.entity.Topic;
import com.sustech.topic_service.service.TopicService;
import com.sustech.global.entity.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topic_service")
@CrossOrigin
public class TopicController {
    @Autowired
    private TopicService topicService;

    @ApiOperation(value = "增加话题")
    @PostMapping("addTopic")
    public Result updateChapterInfo(@RequestBody Topic topic) {
        if (topicService.save(topic))
            return Result.ok().code(200);
        return Result.error();
    }
}
