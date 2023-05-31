package com.sustech.main_service.entity;

import lombok.Data;

@Data
public class UserCollection {
    Integer id;
    String user_id;
    String topic_id;
    String article_id;
    Integer valid;
    String gmt_create;
    String gmt_modified;
}
