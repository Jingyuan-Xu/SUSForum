package com.sustech.main_service.service;

import com.sustech.main_service.entity.Article;
import com.sustech.main_service.entity.User;

import java.util.List;

/**
 * @author Lynchrocket
 * @description 针对表【t_user(用户表)】的数据库操作Service
 * @createDate 2023-04-08 23:26:57
 */
public interface UserService {

    boolean addUser(User user);

    User getByUserId(String id);

    User getByUsername(String username);

    boolean reviseInfo(User user);
}
