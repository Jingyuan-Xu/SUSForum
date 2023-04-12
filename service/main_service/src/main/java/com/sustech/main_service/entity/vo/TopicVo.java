package com.sustech.main_service.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class TopicVo implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
    /**
     * 话题标题
     */
    private String title;

    /**
     * 话题提出者（用户的名字）
     */
    private String poster;
    /**
     * 是否匿名
     */
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