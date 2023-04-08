package com.sustech.user_service.mapper;

import com.sustech.user_service.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Lynchrocket
* @description 针对表【t_user(用户表)】的数据库操作Mapper
* @createDate 2023-04-08 23:26:57
* @Entity com.sustech.user_service.entity.User
*/
public interface UserMapper extends BaseMapper<User> {
//    @Select("select * from user_info where username = #{username}")
//    User getUserByUsername(String username);
}




