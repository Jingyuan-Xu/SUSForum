package com.sustech.main_service.service;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Article;
import com.sustech.main_service.entity.Topic;

import java.util.List;

/**
 * @author Lynchrocket
 * @description 针对表【t_topic(话题表)】的数据库操作Service
 * @createDate 2023-04-08 22:35:49
 */
public interface TopicService {
    boolean addTopic(Topic topic);

    List<Topic> getUserTopics(String userId);

    Result getAllTopic();
    Result getById(String id);
}
