package com.sustech.main_service.entity;

import lombok.Data;

@Data
public class Comment {
    Integer id;
    String content;
    String topicId;
    String path;
    String userId;
    Integer likes;
    Boolean isAnonymous;
    String gmtCreate;
    String gmtModified;
}
