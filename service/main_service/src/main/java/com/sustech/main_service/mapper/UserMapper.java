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

    @Insert("INSERT INTO t_user VALUES(#{user.id}, #{user.username}, #{user.password}, #{user.nick_name}, #{user.email}, #{user.avatar}, #{user.role}, #{user.gmtCreate}, #{user.gmtMdified})")
    int addUser(User user);

    @Update("UPDATE t_user SET username=#{username},nick_name=#{nick_name},email=#{email},avatar=#{avatar},background=#{background} where id=#{id}")
    int revise(String id, String username, String password, String nick_name, String email, String avatar, String background);

    @Select("SELECT * FROM t_user WHERE username=#{username}")
    User getByUsername(String username);

    @Select("SELECT * FROM t_user WHERE id=#{id}")
    User getByUserId(String id);
}




