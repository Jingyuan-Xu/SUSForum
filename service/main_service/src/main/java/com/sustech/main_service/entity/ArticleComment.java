package com.sustech.main_service.entity;

import lombok.Data;

@Data
public class ArticleComment {
    Integer id;
    String content;
    String article_id;
    String path;
    String user_id;
    Integer likes;
    Boolean is_anonymous;
    String gmt_create;
    String gmt_modified;
}
