package com.sustech.main_service.service.impl;

import com.alibaba.druid.sql.PagerUtils;
import com.sustech.main_service.entity.Article;
import com.sustech.main_service.entity.Topic;
import com.sustech.main_service.mapper.TopicMapper;
import com.sustech.main_service.service.TopicService;
import com.sustech.main_service.utils.SnowFlake;
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
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        topic.setGmtCreate(currentTime);
        topic.setGmtModified(currentTime);
        topic.setId(SnowFlake.nextId());
        return topicMapper.addTopic(topic) > 0;
    }

    @Override
    public List<Topic> getTopicPage(int currentPage, int pageSize) {
        if(currentPage <= 0 || pageSize <= 0)
            return null;
        int firstIndex = (currentPage - 1) * pageSize;
        int lastIndex = currentPage * pageSize;
        return topicMapper.getTopicPage(firstIndex, lastIndex);
    }

    @Override
    public List<Topic> getUserTopics(String userId){
        return topicMapper.getUserTopics(userId);
    }
}




