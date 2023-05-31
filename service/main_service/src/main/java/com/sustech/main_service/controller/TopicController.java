package com.sustech.main_service.controller;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Topic;
import com.sustech.main_service.service.TopicService;
import com.sustech.main_service.service.UserService;
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

    @Autowired
    private UserService userService;

    @ApiOperation(value = "增加话题")
    @PostMapping("save")
    public Result addTopic(String title, boolean is_Anonymous, String user_id) {
        Topic topic = new Topic();
        topic.setTitle(title);
        topic.setIs_anonymous(is_Anonymous);
        topic.setUser_id(user_id);
        if (topicService.addTopic(topic)) {
            return Result.ok().code(200);
        }
        return Result.error();
    }

    @GetMapping("all")
    public Result getAllTopic() {
        return topicService.getAllTopic();
    }

    @GetMapping("getById")
    public Result getTopicById(String id) {
        return topicService.getById(id);
    }

}
