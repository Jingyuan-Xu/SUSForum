package com.sustech.user_service.service.impl;

import com.sustech.global.entity.User;
import com.sustech.user_service.mapper.UserMapper;
import com.sustech.user_service.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl implements LoginService {
    @Autowired
    UserMapper mapper;
    @Override
    public boolean login(String username, String password) {
        User user = mapper.getUserByUsername(username);
        return user != null;
    }
}
