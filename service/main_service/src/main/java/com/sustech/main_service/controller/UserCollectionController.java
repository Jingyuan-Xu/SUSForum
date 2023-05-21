package com.sustech.main_service.controller;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.UserCollection;
import com.sustech.main_service.service.UserCollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@Api("用户收藏模块")
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
        userCollection.setUserId(userId);
        if (isArticle) {
            userCollection.setArticleId(articleOrTopicId);
        } else {
            userCollection.setTopicId(articleOrTopicId);
        }
        if (userCollectionService.addUserCollection(userCollection)) {
            return Result.ok().code(200).message("Success to add collection.").data(Map.of("data", userCollection));
        }
        return Result.error().message("Fail to add collection");
    }

    @ApiOperation(value = "删除收藏")
    @PostMapping("addUserCollections")
    public Result addUserCollections(String userId, String id) {
        UserCollection userCollection = userCollectionService.getByUserCollectionId(id);
        if (!userCollection.getUserId().equals(userId)) {
            return Result.error().message("Can not delete collection");
        }
        if(userCollectionService.deleteUserCollection(id)){
            return Result.ok().message("Success to delete collection");
        }
        return Result.error().message("Fail to delete collection");
    }
}
