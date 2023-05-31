package com.sustech.video_service.controller;
import com.sustech.global.entity.Result;
import com.sustech.video_service.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("video")
@Api(tags = "video 模块")
@CrossOrigin
public class VideoController {
    @Autowired
    VideoService service;

    @PostMapping("upload")
    @ApiOperation("上传视频")
    public Result upload(String file,String user_id,String title,String info,String cover,String type){
        return service.upload(file,user_id,title,info,cover,type);
    }

    @GetMapping("getVideo")
    @ApiOperation("获取视频信息")
    public Result getById(String id){
        return service.getVideo(id);
    }

    @GetMapping("all")
    public Result getAll(){
        return service.getAll();
    }

    @PostMapping("delete")
    @ApiOperation("删除视频")
    public Result delete(String url){
        return service.delete(url);
    }

    @GetMapping("getVideoByUserId")
    public Result getVideoByUserId(String user_id){
        return service.getVideoByUserId(user_id);
    }
}
