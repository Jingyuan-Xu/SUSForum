package com.sustech.main_service.service.impl;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Topic;
import com.sustech.main_service.mapper.TopicMapper;
import com.sustech.main_service.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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
        topic.setValid(true);
        return topicMapper.addTopic(topic) > 0;
    }

    @Override
    public boolean deleteTopic(String id) {
        Topic topic = topicMapper.getByTopicId(id);
        topic.setValid(false);
        return topicMapper.reviseTopic(topic) > 0;
    }

    @Override
    public Topic getByTopicId(String id) {
        return topicMapper.getByTopicId(id);
    }

    @Override
    public List<Topic> getTopicPage(int currentPage, int pageSize) {
        if (currentPage <= 0 || pageSize <= 0)
            return null;
        int firstIndex = (currentPage - 1) * pageSize;
        int lastIndex = currentPage * pageSize;
        return topicMapper.getTopicPage(firstIndex, lastIndex);
    }

    @Override
    public List<Topic> getUserTopics(String userId) {
        return topicMapper.getUserTopics(userId);
    }
}




