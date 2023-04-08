package com.sustech.user_service.service;

import com.sustech.user_service.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Lynchrocket
* @description 针对表【t_user(用户表)】的数据库操作Service
* @createDate 2023-04-08 23:26:57
*/
public interface UserService extends IService<User> {

    User getByUsername(String username);
}
