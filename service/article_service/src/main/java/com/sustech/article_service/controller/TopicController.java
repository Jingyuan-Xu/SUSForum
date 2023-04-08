package com.sustech.article_service.controller;

import com.sustech.article_service.service.TopicService;
import com.sustech.global.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/article/topic")
@Api(value = "接口测试类", tags = "话题测试类")
public class TopicController {

    @Autowired
    TopicService topicService;

    @PostMapping("save")
    @ApiOperation("储存话题测试")
    public Result saveTopic(String title,String poster,boolean is_anonymous){
        int num = topicService.insertTopic(title,poster,is_anonymous);
        if(num>0) {
            Map<String,Object> map=new HashMap<>();
            map.put("insert",num);
            return Result.ok().code(200).data(map);
        }
        return Result.error();
    }

}
