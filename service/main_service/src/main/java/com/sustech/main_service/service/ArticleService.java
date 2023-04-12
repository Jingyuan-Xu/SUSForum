package com.sustech.main_service.service;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Article;

public interface ArticleService {

    boolean saveArticle(String id, String title,String content,String user_id,boolean is_anonymous);

    Result getArticle(String id);
}
