package com.sustech.main_service.controller;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Article;
import com.sustech.main_service.entity.User;
import com.sustech.main_service.service.ArticleService;
import com.sustech.main_service.service.UserService;
import com.sustech.main_service.utils.SnowFlake;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/article")
@CrossOrigin
@Api("文章测试类")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;

    @PostMapping("save")
    @ApiOperation("保存文章")
    public Result saveArticle(String id,String title,String content,String user_id,String cover) {
        Article article = new Article();
        article.setCover(cover);
        article.setTitle(title);
        article.setId(id);
        article.setContent(content);
        article.setUser_id(user_id);
        if (articleService.saveArticle(article)) {
            return Result.ok().code(200);
        }
        return Result.error().code(5000).message("文章已存在");
    }

    @ApiOperation("查询文章")
    @GetMapping("getById")
    public Result getArticle(String id) {
        Article article = articleService.getByArticleId(id);
        if (article == null) {
            return Result.error().code(4000).message("No article found");
        }
        return Result.ok().code(200).data(Map.of("article", article));
    }

    @ApiOperation("查询文章分页列表")
    @PostMapping("getPage")
    public Result getArticlePage(int currentPage, int pageSize) {
        List<Article> articlePage = articleService.getArticlePage(currentPage, pageSize);
        if (articlePage == null || articlePage.size() == 0)
            return Result.error().message("No article");
        List<Article> articleVoPage = new ArrayList<>();

        for (Article article : articlePage) {
            User author = userService.getByUserId(article.getUser_id());
            article.setUser_id(author.getNickName());
            articleVoPage.add(article);
        }

//        List<Article> articleVoPage = articlePage.stream().peek(x->{
//            User author = userService.getByUserId(x.getUserId());
//            x.setUserId(author.getNick_name());
//        }).collect(Collectors.toList());
        Map<String, Object> map = new HashMap<>();
        map.put("data", articleVoPage);
        return Result.ok().code(200).data(map);
    }

    @ApiOperation("查询文章列表")
    @PostMapping("getAllArticle")
    public Result getAllArticle() {
        List<Article> articlePage = articleService.getAllArticle();
        if (articlePage == null || articlePage.size() == 0)
            return Result.error().message("No article");
        List<Article> articleVoPage = new ArrayList<>();

        for (Article article : articlePage) {
            User author = userService.getByUserId(article.getUser_id());
            article.setUser_id(author.getNickName());
            articleVoPage.add(article);
        }

//        List<Article> articleVoPage = articlePage.stream().peek(x->{
//            User author = userService.getByUserId(x.getUserId());
//            x.setUserId(author.getNick_name());
//        }).collect(Collectors.toList());
        Map<String, Object> map = new HashMap<>();
        map.put("data", articleVoPage);
        return Result.ok().code(200).data(map);
    }

    @PostMapping("comment")
    public Result comment(String info,String article_id,String user_id,String path){
        return articleService.addComment(user_id,article_id,info,path);
    }


}
