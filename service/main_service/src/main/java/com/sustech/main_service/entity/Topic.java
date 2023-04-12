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
public class Topic implements Serializable {
    /**
     * 主键ID
     */
    private String id;
    /**
     * 话题标题
     */
    private String title;

    /**
     * 话题提出者（外键关联t_user）
     */
    private String userId;
    /**
     * 是否匿名
     */
    private Boolean isAnonymous;

    private int views;

    private int answers;

    private int likes;

    /**
     * 创建时间
     */
    private String gmtCreate;

    /**
     * 修改时间
     */
    private String gmtModified;
}