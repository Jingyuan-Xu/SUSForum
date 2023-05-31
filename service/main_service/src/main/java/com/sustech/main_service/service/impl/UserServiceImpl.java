package com.sustech.main_service.service.impl;

import com.sustech.global.utils.DateUtils;
import com.sustech.main_service.entity.User;
import com.sustech.main_service.mapper.UserMapper;
import com.sustech.main_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataUnit;

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
        String currentTime = DateUtils.getCurrDate();
        user.setGmt_create(currentTime);
        user.setGmt_modified(currentTime);
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
    public boolean reviseInfo(User user) {
        return userMapper.revise(user) > 0;
    }
}




