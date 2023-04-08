package com.sustech.article_service.service;

import org.springframework.stereotype.Service;

public interface TopicService {
    int insertTopic(String title,String poster,boolean is_anonymous);
}
