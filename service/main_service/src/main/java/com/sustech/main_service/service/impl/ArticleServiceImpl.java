package com.sustech.main_service.service.impl;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Article;
import com.sustech.main_service.mapper.ArticleMapper;
import com.sustech.main_service.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper mapper;


    @Override
    public boolean saveArticle(String id, String title, String content, String user_id, boolean is_anonymous) {
        if(getArticle(id).isState()) return false;
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        return mapper.insertArticle(id,title,content,user_id,is_anonymous,currentTime)>0;
    }

    @Override
    public Result getArticle(String id) {
        Article article = mapper.selectById(id);
        if(article==null) return Result.error().code(4000).message("no article found");
        Map<String,Object> data = new HashMap<>();
        data.put("article",article);
        return Result.ok().code(200).data(data);
    }


}