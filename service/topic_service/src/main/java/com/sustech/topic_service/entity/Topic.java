package com.sustech.topic_service.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 话题表
 *
 * @TableName t_topic
 */
@TableName(value = "t_topic")
@Data
public class Topic implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    /**
     * 话题标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 话题提出者（外键关联t_user）
     */
    @TableField(value = "user_id")
    private String user_id;
    /**
     * 是否匿名
     */
    @TableField(value = "is_anonymous")
    private Boolean is_anonymous;

    /**
     * 创建时间
     */
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmt_create;

    /**
     * 修改时间
     */
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date gmt_modified;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}