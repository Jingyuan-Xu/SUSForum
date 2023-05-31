package com.sustech.main_service.controller;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.UserCollection;
import com.sustech.main_service.service.UserCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "用户收藏模块")
@RestController
@RequestMapping("/userCollection")
@CrossOrigin
public class UserCollectionController {
    @Autowired
    private UserCollectionService userCollectionService;

    @ApiOperation(value = "新增收藏")
    @PostMapping("addUserCollections")
    public Result addUserCollections(String userId, String articleOrTopicId, boolean isArticle) {
        UserCollection userCollection = new UserCollection();
        userCollection.setUser_id(userId);
        if (isArticle) {
            userCollection.setArticle_id(articleOrTopicId);
        } else {
            userCollection.setTopic_id(articleOrTopicId);
        }
        if (userCollectionService.addUserCollection(userCollection)) {
            Map<String,Object> map = new HashMap<>();
            map.put("collection", userCollection);
            return Result.ok().code(200).message("Success to add collection.").data(map);
        }
        System.out.println("outer");
        return Result.error().message("Fail to add collection");
    }

    @ApiOperation(value = "删除收藏")
    @PostMapping("deleteUserCollections")
    public Result deleteUserCollections(String userId, int collectionId) {
        UserCollection userCollection = userCollectionService.getByUserCollectionId(collectionId);
        if (userCollection == null || !userCollection.getUser_id().trim().equals(userId)) {
            return Result.error().message("Can not delete collection");
        }
        if (userCollectionService.deleteUserCollection(collectionId)) {
            return Result.ok().message("Success to delete collection");
        }
        return Result.error().message("Fail to delete collection");
    }
}
