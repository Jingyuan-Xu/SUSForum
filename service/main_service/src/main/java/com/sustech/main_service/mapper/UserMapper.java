package com.sustech.main_service.mapper;

import com.sustech.main_service.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Lynchrocket
 * @description 针对表【t_user(用户表)】的数据库操作Mapper
 * @createDate 2023-04-08 23:26:57
 * @Entity com.sustech.user_service.entity.User_0
 */
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO t_user VALUES(#{id}, #{username}, #{password}, #{nickName}, #{email}, #{avatar}, #{background}, #{role}, #{gmtCreate}, #{gmtModified})")
    int addUser(User user);

    @Update("UPDATE t_user SET username=#{username},password=#{password},nick_name=#{nick_name},email=#{email},avatar=#{avatar},background=#{background} WHERE id=#{id}")
    int revise(User user);

    @Select("SELECT * FROM t_user WHERE username=#{username}")
    User getByUsername(String username);

    @Select("SELECT * FROM t_user WHERE id=#{id}")
    User getByUserId(String id);
}




