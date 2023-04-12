package com.sustech.main_service.controller;

import com.sustech.global.entity.Result;
import com.sustech.main_service.service.ArticleService;
import com.sustech.main_service.utils.SnowFlake;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
@Api("文章测试类")
public class ArticleController {

    @Autowired
    ArticleService service;

    @PostMapping("save")
    @ApiOperation("保存文章")
    public Result saveArticle(String title,String content,String user_id,boolean is_anonymous){
        if(service.saveArticle(SnowFlake.nextId(),title,content,user_id,is_anonymous)){
            return Result.ok().code(200);
        }
        return Result.error().code(5000).message("文章已存在");
    }

    @ApiOperation("查询文章")
    @GetMapping("getById")
    public Result getArticle(String id){
        return service.getArticle(id);
    }




}
