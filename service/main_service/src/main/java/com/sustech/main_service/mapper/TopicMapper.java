package com.sustech.main_service.mapper;

import com.sustech.main_service.entity.Article;
import com.sustech.main_service.entity.Topic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Lynchrocket
 * @description 针对表【t_topic(话题表)】的数据库操作Mapper
 * @createDate 2023-04-08 22:35:49
 * @Entity com.example.topic_service.entity.Topic
 */
@Mapper
public interface TopicMapper {

    @Insert("INSERT INTO t_topic VALUES (#{id}, #{title}, #{user_id}, #{is_anonymous}, #{views}, #{answers}, #{likes}, #{valid})")
    int addTopic(Topic topic);

    @Update("UPDATE t_topic SET title=#{title},user_id=#{user_id},is_anonymous=#{is_anonymous},views=#{views},answers=#{answers},likes=#{likes},valid=#{valid} WHERE id=#{id}")
    int reviseTopic(Topic topic);

    @Select("SELECT * FROM t_topic WHERE id=#{id}")
    Topic getByTopicId(String id);

    @Select("SELECT * FROM t_topic LIMIT (#{lastIndex}-#{firstIndex}) OFFSET #{firstIndex}")
    List<Topic> getTopicPage(int firstIndex, int lastIndex);

    @Select("SELECT * FROM t_topic WHERE user_id=#{userId}")
    List<Topic> getUserTopics(String userId);
}




