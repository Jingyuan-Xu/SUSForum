package com.sustech.main_service.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
* @author Lynchrocket
* @description 针对表【t_user(用户表)】的数据库操作Mapper
* @createDate 2023-04-08 23:26:57
* @Entity com.sustech.user_service.entity.User_0
*/
@Mapper
public interface UserMapper {

    @Update("update t_user set username=#{username},nick_name=#{nick_name},email=#{email},avatar=#{avatar},background=#{background} where id=#{id}")
    int revise(String id,String username,String password,String nick_name,String email,String avatar,String background);



}




