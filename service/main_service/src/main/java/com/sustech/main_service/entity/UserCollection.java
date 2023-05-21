package com.sustech.main_service.entity;

import lombok.Data;

@Data
public class UserCollection {
    Long id;
    String user_id;
    String topic_id;
    String article_id;
    Integer status;
    String gmt_create;
    String gmt_modified;
}
