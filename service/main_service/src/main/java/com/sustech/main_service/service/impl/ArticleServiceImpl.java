package com.sustech.main_service.service.impl;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Article;
import com.sustech.main_service.entity.Topic;
import com.sustech.main_service.mapper.ArticleMapper;
import com.sustech.main_service.service.ArticleService;
import com.sustech.main_service.utils.SnowFlake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        article.setId(SnowFlake.nextId());
        article.setLikes(0);
        if (article.getCover() == null) article.setCover("");
        if (article.getIs_anonymous() == null) article.setIs_anonymous(false);
        return articleMapper.addArticle(article) > 0;
    }

    @Override
    public Result getById(String id) {
        Article article = articleMapper.selectById(id);
        if (article == null) return Result.error().code(4000).message("no article found");
        Map<String, Object> data = new HashMap<>();
        data.put("article", article);
        return Result.ok().code(200).data(data);
    }

    @Override
    public List<Article> getArticlePage(int currentPage, int pageSize) {
        if (currentPage <= 0 || pageSize <= 0)
            return null;
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
}
