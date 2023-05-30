package com.sustech.main_service.entity.VO;

import lombok.Data;

@Data
public class UserCollectionVO {
    Long id;
    String userId;
    String topicId;
    String topicTitle;
    String articleId;
    String articleTitle;
}
