package com.sustech.main_service.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sustech.main_service.entity.User;
import com.sustech.main_service.mapper.UserMapper;
import com.sustech.main_service.service.UserService;
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

    @Override
    public User getByNickName(String nickName) {
        return getOne(Wrappers.<User>lambdaQuery().eq(User::getNickName, nickName));
    }
}




