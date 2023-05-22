package com.sustech.video_service.service;

import com.sustech.global.entity.Result;
import org.springframework.web.multipart.MultipartFile;

public interface VideoService {

    Result upload(String file,String user_id,String title,String info);

    Result delete(String url);

    Result getVideo(String url);

}
