package com.sustech.main_service.service;

import com.sustech.main_service.entity.Topic;
import com.sustech.main_service.entity.UserCollection;

import java.util.List;

public interface UserCollectionService {
    boolean addUserCollection(UserCollection userCollection);

    boolean deleteUserCollection(String id);

    UserCollection getByUserCollectionId(String id);

    List<UserCollection> getUserCollections(String userId);
}
