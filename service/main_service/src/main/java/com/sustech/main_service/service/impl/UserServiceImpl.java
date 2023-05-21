package com.sustech.main_service.service.impl;

import com.sustech.main_service.entity.Article;
import com.sustech.main_service.entity.User;
import com.sustech.main_service.mapper.UserMapper;
import com.sustech.main_service.service.UserService;
import com.sustech.main_service.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Lynchrocket
 * @description 针对表【t_user(用户表)】的数据库操作Service实现
 * @createDate 2023-04-08 23:26:57
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean addUser(User user) {
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        user.setGmt_create(currentTime);
        user.setGmt_modified(currentTime);
        user.setId(SnowFlake.nextId());
        return userMapper.addUser(user) > 0;
    }

    @Override
    public User getByUserId(String id) {
        return userMapper.getByUserId(id);
    }

    @Override
    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    @Override
    public boolean reviseInfo(String id, String username, String password, String nick_name, String email, String avatar, String background) {
        return userMapper.revise(id, username, password, nick_name, email, avatar, background) > 0;
    }
}




