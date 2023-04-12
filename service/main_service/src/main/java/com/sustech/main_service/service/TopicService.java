package com.sustech.main_service.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sustech.main_service.entity.Topic;
import com.sustech.main_service.entity.vo.TopicVo;

/**
 * @author Lynchrocket
 * @description 针对表【t_topic(话题表)】的数据库操作Service
 * @createDate 2023-04-08 22:35:49
 */
public interface TopicService extends IService<Topic> {
    int addTopicVo(TopicVo topicVo);
}
