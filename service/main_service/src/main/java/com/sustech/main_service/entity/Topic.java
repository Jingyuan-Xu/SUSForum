package com.sustech.main_service.entity;

import lombok.Data;

import java.io.Serializable;

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
    private String user_id;

    /**
     * 是否匿名
     */
    private Boolean is_anonymous;

    /**
     * 阅览人数
     */
    private Integer views;

    /**
     * 回答人数
     * */
    private Integer answers;

    /**
     * 点赞数
     * */
    private Integer likes;

    private Boolean valid;

    /**
     * 创建时间
     */
    private String gmt_create = "";
    /**
     * 修改时间
     */
    private String gmt_modified = "";
}