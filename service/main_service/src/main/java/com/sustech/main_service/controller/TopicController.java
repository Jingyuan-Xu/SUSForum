package com.sustech.main_service.controller;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Topic;
import com.sustech.main_service.entity.vo.TopicVo;
import com.sustech.main_service.service.TopicService;
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
    public Result addTopic(@RequestBody Topic topic) {
//        if (topicService.save(topic))
//            return Result.ok().code(200);
        return Result.error();
    }

    @ApiOperation(value = "增加话题（以用户的名字而非id）")
    @PostMapping("addTopicVo")
    public Result addTopicVo(@RequestBody TopicVo topicVo) {
        return Result.error();
    }
}
