package com.sustech.video_service.entity;

import lombok.Data;

@Data
public class Video {
    String id;
    String url;
    String title;
    String brief;
    String uploader;
    String cover;
    String gmt_create;
    String gmt_modified;
    String type;
}
