package com.sustech.main_service.controller;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Article;
import com.sustech.main_service.entity.Comment;
import com.sustech.main_service.entity.Topic;
import com.sustech.main_service.entity.User;
import com.sustech.main_service.mapper.CommentMapper;
import com.sustech.main_service.mapper.TopicMapper;
import com.sustech.main_service.service.ArticleService;
import com.sustech.main_service.service.CommentService;
import com.sustech.main_service.service.TopicService;
import com.sustech.main_service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api("用户个人中心模块")
@RestController
@RequestMapping("/userCenter")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private CommentService commentService;

    @ApiOperation(value = "获取用户所有数据")
    @GetMapping("getUserData")
    public Result getUserData(String userId) {
        User user = userService.getByUserId(userId);
        if (user == null) {
            return Result.error().message("No such user");
        }

        return Result.ok().code(200).data(Map.of("data", user));
    }

    @ApiOperation(value = "修改用户数据")
    @GetMapping("editUserData")
    public Result editUserData(User user) {
        User dbUser = userService.getByUserId(user.getId());
        if (dbUser == null) {
            return Result.error().message("No such user");
        }
        userService.reviseInfo(user.getId(), user.getUsername(), user.getPassword(), user.getNick_name(), user.getEmail(), user.getAvatar(), user.getBackground());
        return Result.ok().code(200);
    }

    @ApiOperation(value = "返回用户文章")
    @GetMapping("getUserArticles")
    public Result getUserArticles(String userId) {
        User user = userService.getByUserId(userId);
        if (user == null) {
            return Result.error().message("No such user");
        }
        List<Article> articleList = articleService.getUserArticles(userId);
        if (articleList == null) {
            return Result.error().message("No such user articles");
        }
        return Result.ok().code(200).data(Map.of("data", articleList));
    }

    @ApiOperation(value = "返回用户话题")
    @GetMapping("getUserTopics")
    public Result getUserTopics(String userId) {
        User user = userService.getByUserId(userId);
        if (user == null) {
            return Result.error().message("No such user");
        }
        List<Topic> topicList = topicService.getUserTopics(userId);
        if (topicList == null) {
            return Result.error().message("No such user topics");
        }
        return Result.ok().code(200).data(Map.of("data", topicList));
    }

    @ApiOperation(value = "返回用户评论")
    @GetMapping("getUserComments")
    public Result getUserComments(String userId) {
        User user = userService.getByUserId(userId);
        if (user == null) {
            return Result.error().message("No such user");
        }
        List<Comment> commentList = commentService.getUserComments(userId);
        if (commentList == null) {
            return Result.error().message("No such user comments");
        }
        return Result.ok().code(200).data(Map.of("data", commentList));
    }
}
