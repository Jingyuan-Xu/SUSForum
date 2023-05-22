package com.sustech.main_service.controller;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Article;
import com.sustech.main_service.entity.ArticleComment;
import com.sustech.main_service.entity.User;
import com.sustech.main_service.service.ArticleService;
import com.sustech.main_service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
@CrossOrigin
@Api(tags = "文章测试类")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;

    @PostMapping("save")
    @ApiOperation("保存文章")
    public Result saveArticle(String id, String title, String content, String user_id, String cover) {
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
            article.setUser_id(author.getNick_name());
            articleVoPage.add(article);
        }
        return Result.ok().code(200).data(Map.of("articleVoPage", articleVoPage));
    }

    @ApiOperation("查询文章列表")
    @GetMapping("getAllArticle")
    public Result getAllArticle() {
        List<Article> articlePage = articleService.getAllArticle();
        if (articlePage == null || articlePage.size() == 0)
            return Result.error().message("No article");
        List<Article> articleVoPage = new ArrayList<>();
        for (Article article : articlePage) {
            User author = userService.getByUserId(article.getUser_id());
            article.setUser_id(author.getNick_name());
            articleVoPage.add(article);
        }
        return Result.ok().code(200).data(Map.of("articleVoPage", articleVoPage));
    }

    @ApiOperation("评论文章")
    @PostMapping("commentArticle")
    public Result commentArticle(String info, String articleId, String userId, String path) {
        return articleService.addComment(userId, articleId, info, path);
    }

    @ApiOperation("获取文章评论")
    @PostMapping("getArticleComments")
    public Result getArticleComments(String id) {
        List<ArticleComment> articleCommentList = articleService.getArticleComments(id);
        if (articleCommentList == null) {
            return Result.error().message("Fail to get article comments");
        }
        return Result.ok().data(Map.of("articleComments", articleCommentList));
    }

    @ApiOperation("点赞文章")
    @PostMapping("likeArticle")
    public Result likeArticle(String articleId) {
        if (articleService.likeArticle(articleId)) {
            return Result.ok().message("Like increased by 1");
        }
        return Result.error().message("Error in like");
    }

    @ApiOperation("取消点赞")
    @PostMapping("unlikeArticle")
    public Result unlikeArticle(String articleId) {
        if (articleService.unlikeArticle(articleId)) {
            return Result.ok().message("Like decreased by 1");
        }
        return Result.error().message("Error in like");
    }
}
