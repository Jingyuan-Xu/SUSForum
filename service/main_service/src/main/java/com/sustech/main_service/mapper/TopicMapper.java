package com.sustech.main_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sustech.main_service.entity.Topic;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Lynchrocket
* @description 针对表【t_topic(话题表)】的数据库操作Mapper
* @createDate 2023-04-08 22:35:49
* @Entity com.example.topic_service.entity.Topic
*/
@Mapper
public interface TopicMapper extends BaseMapper<Topic> {

}



