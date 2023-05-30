package com.sustech.main_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 话题表
 *
 * @TableName t_topic
 */
@Data
public class Topic{
    /**
     * 主键ID
     */
    private String id;
    private String title = "";
    private String user_id;
    private Boolean is_anonymous = false;
    private Integer views = 0;
    private Integer answers = 0;
    private Integer likes = 0;
    private boolean valid = true;
    private String gmt_create;
    private String gmt_modified;
}