package com.sustech.main_service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sustech.main_service.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Lynchrocket
* @description 针对表【t_user(用户表)】的数据库操作Mapper
* @createDate 2023-04-08 23:26:57
* @Entity com.sustech.user_service.entity.User_0
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




