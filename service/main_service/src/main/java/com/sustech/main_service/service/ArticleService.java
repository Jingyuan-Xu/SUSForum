package com.sustech.main_service.service;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Article;
import com.sustech.main_service.entity.Topic;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleService {

    boolean saveArticle(Article article);

    Result getById(String id);

    List<Article> getArticlePage(int currentPage, int pageSize);
}
