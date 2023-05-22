package com.sustech.main_service.mapper;

import com.sustech.main_service.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Insert("insert into t_article values(#{id},#{title},#{content},#{user_id},#{tags},#{likes},#{cover},#{is_anonymous},#{gmt_create},#{gmt_modified})")
    int addArticle(Article article);

    @Select("select * from t_article where id=#{id}")
    Article getById(String id);

    @Select("SELECT * FROM t_article LIMIT (#{lastIndex}-#{firstIndex}) OFFSET #{firstIndex}")
    List<Article> getArticlePage(int firstIndex, int lastIndex);

    @Select("SELECT * FROM t_article WHERE user_id=#{userId}")
    List<Article> getUserArticles(String userId);
    @Select("SELECT * FROM t_article")
    List<Article> getAllArticle();

    @Insert("insert into t_article_comment(content,article_id,path,user_id,is_anonymous,gmt_create) values(#{content},#{article_id},#{path},#{user_id},#{is_anonymous},#{gmt_create})")
    int addComment(String user_id,String article_id,String content,String path,boolean is_anonymous,String gmt_create);

    @Update("UPDATE t_article SET likes=likes+1 WHERE id=#{articleId}")
    int likeArticle(String articleId);
    @Update("UPDATE t_article SET likes=likes-1 WHERE id=#{articleId}")
    int unlikeArticle(String articleId);
}
