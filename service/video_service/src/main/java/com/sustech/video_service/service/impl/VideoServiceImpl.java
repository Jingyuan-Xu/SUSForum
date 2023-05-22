package com.sustech.video_service.service.impl;

import com.sustech.global.entity.Result;
import com.sustech.global.utils.DateUtils;
import com.sustech.video_service.entity.Video;
import com.sustech.video_service.mapper.VideoMapper;
import com.sustech.video_service.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoMapper mapper;

    @Override
    public Result upload(String file, String user_id, String title, String info) {
        mapper.addVideo(file,title,info,user_id, DateUtils.getCurrDate(),DateUtils.getCurrDate());
        return Result.ok().code(200);
    }

    @Override
    public Result delete(String url) {
        mapper.deleteVideo(url);
        return Result.ok().code(200);
    }

    @Override
    public Result getVideo(String url) {
        Video video = mapper.getVideoByURL(url);
        Map<String, Object> map = new HashMap<>();
        map.put("video",video);
        return Result.ok().code(200).data(map);
    }
}
