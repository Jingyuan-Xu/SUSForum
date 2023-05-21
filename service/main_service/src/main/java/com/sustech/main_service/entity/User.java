package com.sustech.main_service.entity;

import lombok.Data;

/**
 * 用户表
 * @TableName t_user
 */
@Data
public class User{
    /**
     * 主键ID
     */
    private String id = "";

    /**
     * 用户名
     */
    private String username = "";

    /**
     * 密码
     */
    private String password = "";

    /**
     * 昵称
     */
    private String nickName = "";

    /**
     * 邮箱
     */
    private String email = "";

    /**
     * 头像
     */
    private String avatar = "";

    /**
     * 背景
     */
    private String background = "";

    /**
     * 角色（0管理员、1普通用户）
     */
    private Integer role = 0;

    /**
     * 创建时间
     */
    private String gmtCreate = "";
    /**
     * 修改时间
     */
    private String gmtModified = "";

}