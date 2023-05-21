package com.sustech.main_service.mapper;

import com.sustech.main_service.entity.UserCollection;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserCollectionMapper {
    @Select("SELECT * FROM t_collection WHERE id=#{id}")
    UserCollection getById(int id);
    @Update("UPDATE t_collection SET status=0 WHERE id=#{id}")
    int deleteUserCollection(int id);
    @Insert("INSERT INTO t_collection(user_id,topic_id,article_id,gmt_create,gmt_modified) VALUES (#{userId},#{topicId},#{articleId},#{gmtCreate},#{gmtModified})")
    int addUserCollection(UserCollection userCollection);
    @Select("SELECT * FROM t_collection WHERE user_id=#{userId}")
    List<UserCollection> getUserCollections(String userId);
}
