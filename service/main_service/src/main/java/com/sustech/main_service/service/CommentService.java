package com.sustech.main_service.service;

import com.sustech.main_service.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getUserComments(String userId);
}
