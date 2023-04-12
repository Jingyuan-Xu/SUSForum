package com.sustech.main_service.entity;

import lombok.Data;

@Data
public class Article {

    String id;
    String title;
    String content;
    String user_id;
    boolean is_anonymous;
    String gmt_create;

}
