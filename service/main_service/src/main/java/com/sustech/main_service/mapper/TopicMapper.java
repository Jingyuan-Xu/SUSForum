package com.sustech.main_service.mapper;

import com.sustech.main_service.entity.Topic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Lynchrocket
 * @description 针对表【t_topic(话题表)】的数据库操作Mapper
 * @createDate 2023-04-08 22:35:49
 * @Entity com.example.topic_service.entity.Topic
 */
@Mapper
public interface TopicMapper {

    @Insert("INSERT INTO t_topic VALUES (#{topic.id}, #{topic.title}, #{topic.user_id}, #{topic.is_anonymous}, #{topic.views}, #{topic.answers}, #{topic.likes})")
    int addTopic(Topic topic);

//    @Select("SELECT * FROM t_topic LIMIT #{(lastIndex-firstIndex)} OFFSET #{firstIndex}")
//    List<Topic> getTopicPage(int firstIndex, int lastIndex);
}




