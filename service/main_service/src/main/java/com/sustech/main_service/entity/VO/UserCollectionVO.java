package com.sustech.main_service.entity.VO;

import lombok.Data;
import org.apache.ibatis.javassist.compiler.ast.Pair;

@Data
public class UserCollectionVO {
    String id;
    String userId;
    String topicId;
    String topicTitle;
    String articleId;
    String articleTitle;
}
