package com.sustech.main_service.mapper;

import com.sustech.main_service.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface ArticleMapper {

    @Insert("insert into t_article values(#{id},#{title},#{content},#{user_id},#{is_anonymous},#{gmt_create})")
    int insertArticle(String id, String title,String content,String user_id,boolean is_anonymous,String gmt_create);

    @Select("select * from t_article where id=#{id}")
    Article selectById(String id);

}
