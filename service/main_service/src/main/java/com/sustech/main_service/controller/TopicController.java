package com.sustech.main_service.controller;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Topic;
import com.sustech.main_service.service.TopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
