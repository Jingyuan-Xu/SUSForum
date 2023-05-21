package com.sustech.main_service.service;

import com.sustech.main_service.entity.Topic;
import com.sustech.main_service.entity.UserCollection;

import java.util.List;

public interface UserCollectionService {
    boolean addUserCollection(UserCollection userCollection);

    boolean deleteUserCollection(int id);

    UserCollection getByUserCollectionId(int id);

    List<UserCollection> getUserCollections(String userId);
}
