package com.sustech.main_service.mapper;

import com.sustech.main_service.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Insert("insert into t_comment values(#{id},#{title},#{content},#{topic_id},#{path},#{user_id},#{likes},#{is_anonymous},#{gmt_create},#{gmt_modified})")
    int addComment(Comment comment);

    @Select("SELECT * FROM t_comment WHERE user_id=#{userId}")
    List<Comment> getUserComments(String userId);
}
