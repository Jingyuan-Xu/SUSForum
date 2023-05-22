package com.sustech.main_service.service.impl;

import com.sustech.global.entity.Result;
import com.sustech.global.utils.DateUtils;
import com.sustech.main_service.entity.Article;
import com.sustech.main_service.entity.ArticleComment;
import com.sustech.main_service.mapper.ArticleMapper;
import com.sustech.main_service.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public boolean saveArticle(Article article) {
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        article.setGmt_create(currentTime);
        article.setGmt_modified(currentTime);
        article.setLikes(0);
        if (article.getCover() == null) article.setCover("");
        if (article.getIs_anonymous() == null) article.setIs_anonymous(false);
        return articleMapper.addArticle(article) > 0;
    }

    @Override
    public Article getByArticleId(String id) {
        return articleMapper.getById(id);
    }

    @Override
    public List<Article> getArticlePage(int currentPage, int pageSize) {
        if (currentPage <= 0 || pageSize <= 0)
            return new ArrayList<>();
        int firstIndex = (currentPage - 1) * pageSize;
        int lastIndex = currentPage * pageSize;
        List<Article> articlePage = articleMapper.getArticlePage(firstIndex, lastIndex);
        articlePage.stream().peek(x -> {
            if (x.getCover() == null) x.setCover("");
        });
        return articlePage;
    }

    @Override
    public List<Article> getUserArticles(String userId) {
        return articleMapper.getUserArticles(userId);
    }

    public List<Article> getAllArticle() {
        return articleMapper.getAllArticle();
    }

    @Override
    public Result addComment(String user_id, String article_id, String info, String path) {
        String time = DateUtils.getCurrDate();
        articleMapper.addComment(user_id, article_id, info, path, false, time);
        return Result.ok().code(200);
    }

    @Override
    public List<ArticleComment> getArticleComments(String id) {
        return articleMapper.getArticleComments(id);
    }

    @Override
    public boolean likeArticle(String articleId) {
        return articleMapper.likeArticle(articleId) > 0;
    }

    @Override
    public boolean unlikeArticle(String articleId) {
        return articleMapper.unlikeArticle(articleId) > 0;
    }
}
