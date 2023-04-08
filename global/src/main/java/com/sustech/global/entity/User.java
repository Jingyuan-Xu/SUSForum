package com.sustech.global.entity;

import lombok.Data;

@Data
public class User {
    private int user_id;
    private String username;
    private String password;
    private String role;
}
