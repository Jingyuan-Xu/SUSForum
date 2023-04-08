package com.sustech.article_service.service.impl;

import com.sustech.article_service.mapper.TopicMapper;
import com.sustech.article_service.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    TopicMapper mapper;


    @Override
    public int insertTopic(String title, String poster, boolean is_anonymous) {
        LocalDate now  = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return mapper.insertTopic(title,poster,is_anonymous,now.format(formatter));
    }





}
