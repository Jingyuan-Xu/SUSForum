package com.sustech.main_service.service.impl;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Topic;
import com.sustech.main_service.mapper.TopicMapper;
import com.sustech.main_service.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author Lynchrocket
 * @description 针对表【t_topic(话题表)】的数据库操作Service实现
 * @createDate 2023-04-08 22:35:49
 */
@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper;

    @Override
    public boolean addTopic(Topic topic) {
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        topic.setGmt_create(currentTime);
        topic.setGmt_modified(currentTime);
        int num = new Random().nextInt(Integer.MAX_VALUE);
        topic.setId(num+"");
        return topicMapper.addTopic(topic) > 0;
    }

    @Override
    public Result getAllTopic() {
        List<Topic> list = topicMapper.getAllTopic();
        Map<String,Object> data = new HashMap<>();
        data.put("topics",list);
        return Result.ok().code(200).data(data);
    }

    @Override
    public Result getById(String id) {
        Topic topic = topicMapper.getByTopicId(id);
        Map<String, Object> data = new HashMap<>();
        data.put("topic",topic);
        return Result.ok().code(200).data(data);
    }

    @Override
    public List<Topic> getUserTopics(String userId){
        return topicMapper.getUserTopics(userId);
    }

}




