package com.sustech.topic_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sustech.topic_service.entity.Topic;
import com.sustech.topic_service.service.TopicService;
import com.sustech.topic_service.mapper.TopicMapper;
import org.springframework.stereotype.Service;

/**
* @author Lynchrocket
* @description 针对表【t_topic(话题表)】的数据库操作Service实现
* @createDate 2023-04-08 22:35:49
*/
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic>
    implements TopicService{

}




