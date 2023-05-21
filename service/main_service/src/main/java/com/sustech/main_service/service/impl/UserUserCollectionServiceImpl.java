package com.sustech.main_service.service.impl;

import com.sustech.main_service.entity.UserCollection;
import com.sustech.main_service.mapper.UserCollectionMapper;
import com.sustech.main_service.service.UserCollectionService;
import com.sustech.main_service.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UserUserCollectionServiceImpl implements UserCollectionService {

    @Autowired
    private UserCollectionMapper userCollectionMapper;

    @Override
    public boolean addUserCollection(UserCollection userCollection) {
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        userCollection.setGmtCreate(currentTime);
        userCollection.setGmtModified(currentTime);
        return userCollectionMapper.addUserCollection(userCollection) > 0;
    }

    @Override
    public boolean deleteUserCollection(String id) {
        return userCollectionMapper.deleteUserCollection(id) > 0;
    }


    @Override
    public UserCollection getByUserCollectionId(String id) {
        return userCollectionMapper.getById(id);
    }

    @Override
    public List<UserCollection> getUserCollections(String userId) {
        return userCollectionMapper.getUserCollections(userId);
    }
}
