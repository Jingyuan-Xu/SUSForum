package com.sustech.main_service.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sustech.main_service.entity.Topic;
import com.sustech.main_service.entity.User;
import com.sustech.main_service.entity.vo.TopicVo;
import com.sustech.main_service.mapper.TopicMapper;
import com.sustech.main_service.service.TopicService;
import org.springframework.stereotype.Service;

/**
 * @author Lynchrocket
 * @description 针对表【t_topic(话题表)】的数据库操作Service实现
 * @createDate 2023-04-08 22:35:49
 */
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic>
        implements TopicService {


    public int addTopicVo(TopicVo topicVo) {

        Topic topic = new Topic();
        return 0;
    }
}




