package com.sustech.main_service.service.impl;

import com.sustech.global.utils.DateUtils;
import com.sustech.main_service.entity.Comment;
import com.sustech.main_service.entity.Topic;
import com.sustech.main_service.mapper.TopicMapper;
import com.sustech.main_service.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public boolean addComment(String user_id, String topic_id, String info, String path) {
        String time = DateUtils.getCurrDate();
        return topicMapper.addComment(user_id, topic_id, info, path, false, time) > 0;
    }

    @Override
    public List<Comment> getTopicComments(String id) {
        return topicMapper.getTopicComments(id);
    }

    @Override
    public Topic getByTopicId(String id) {
        return topicMapper.getByTopicId(id);
    }

    @Override
    public List<Topic> getTopicPage(int currentPage, int pageSize) {
        if (currentPage <= 0 || pageSize <= 0)
            return new ArrayList<>();
        int firstIndex = (currentPage - 1) * pageSize;
        int lastIndex = currentPage * pageSize;
        return topicMapper.getTopicPage(firstIndex, lastIndex);
    }

    @Override
    public List<Topic> getUserTopics(String userId) {
        return topicMapper.getUserTopics(userId);
    }
}




