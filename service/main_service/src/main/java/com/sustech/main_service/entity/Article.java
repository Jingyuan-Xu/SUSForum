package com.sustech.main_service.entity;

import lombok.Data;

@Data
public class Article {
    String id;
    String title;
    String content;
    String userId;
    String tags;
    String likes;
    String cover;
    Boolean isAnonymous;
    String gmtCreate;
    String gmtModified;
}
