package com.sustech.user_service.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sustech.user_service.entity.User;
import com.sustech.user_service.service.UserService;
import com.sustech.user_service.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author Lynchrocket
 * @description 针对表【t_user(用户表)】的数据库操作Service实现
 * @createDate 2023-04-08 23:26:57
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Override
    public User getByUsername(String username) {
        return getOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
    }
}




