package com.sustech.main_service.service.impl;

import com.sustech.main_service.entity.User;
import com.sustech.main_service.mapper.UserMapper;
import com.sustech.main_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lynchrocket
 * @description 针对表【t_user(用户表)】的数据库操作Service实现
 * @createDate 2023-04-08 23:26:57
 */
@Service
public class UserServiceImpl
        implements UserService {


    @Autowired
    UserMapper mapper;


    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public User getByNickName(String nickName) {
        return null;
    }

    @Override
    public boolean reviseInfo(String id, String username, String password, String nick_name, String email, String avatar, String background) {
        return mapper.revise(id,username,password,nick_name,email,avatar,background)>0;
    }
}




