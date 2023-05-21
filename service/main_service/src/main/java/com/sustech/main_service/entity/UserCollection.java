package com.sustech.main_service.entity;

import lombok.Data;

@Data
public class UserCollection {
    String id;
    String userId;
    String topicId;
    String articleId;
    Integer status;
    String gmtCreate;
    String gmtModified;
}
