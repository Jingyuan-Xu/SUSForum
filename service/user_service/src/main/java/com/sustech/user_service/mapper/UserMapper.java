package com.sustech.user_service.mapper;

import com.sustech.global.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user_info where username = #{username}")
    User getUserByUsername(String username);

}
