package com.sustech.video_service.entity;

import lombok.Data;

@Data
public class Video {
    String url;
    String title;
    String brief;
    String uploader;
    String gmt_create;
    String gmt_modified;
}
