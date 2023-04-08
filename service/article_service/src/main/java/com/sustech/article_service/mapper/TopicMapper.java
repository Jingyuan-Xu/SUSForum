package com.sustech.article_service.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicMapper {

    @Insert("insert into t_topic(title,poster,is_anonymous,gmt_create) values(#{title},#{poster},#{is_anonymous},#{gmt_create})")
    int insertTopic(String title,String poster,boolean is_anonymous,String gmt_create);

}
