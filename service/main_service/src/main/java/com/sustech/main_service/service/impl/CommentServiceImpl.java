package com.sustech.main_service.service.impl;

import com.sustech.main_service.entity.Comment;
import com.sustech.main_service.mapper.CommentMapper;
import com.sustech.main_service.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getUserComments(String userId) {
        return commentMapper.getUserComments(userId);
    }
}
