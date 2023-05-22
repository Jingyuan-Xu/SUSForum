package com.sustech.main_service.service;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.Article;
import com.sustech.main_service.entity.ArticleComment;

import java.util.List;

public interface ArticleService {

    boolean saveArticle(Article article);

    Article getByArticleId(String id);

    List<Article> getArticlePage(int currentPage, int pageSize);

    List<Article> getUserArticles(String id);
    List<Article> getAllArticle();

    Result addComment(String user_id,String article_id,String info,String path);

    List<ArticleComment> getArticleComments(String id);

    boolean likeArticle(String articleId);

    boolean unlikeArticle(String articleId);
}
