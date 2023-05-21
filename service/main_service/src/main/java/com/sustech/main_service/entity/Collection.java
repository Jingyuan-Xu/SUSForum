package com.sustech.main_service.entity;

import lombok.Data;

@Data
public class Collection {
    String id;
    String userId;
    String topicId;
    String articleId;
    String gmtCreate;
    String gmtModified;
}
