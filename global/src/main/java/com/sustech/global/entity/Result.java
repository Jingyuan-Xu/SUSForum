package com.sustech.global.entity;

import lombok.Data;
import java.util.Map;

/**
 * @Description: 所有后端向前端返回的结果，都应该为Result对象，Result对象请使用链式编程创建，不要暴力破解
 */
@Data
public class Result {

    private Result(){}

    private int code;
    private String message;
    private boolean state;
    private Map<String,Object> data;

    public static Result ok(){
        Result result=new Result();
        result.state=true;
        return result;
    }

    public static Result error(){
        Result result=new Result();
        result.state=false;
        return result;
    }

    public Result message(String message){
        this.message=message;
        return this;
    }

    public Result code(int code){
        this.code=code;
        return this;
    }

    public Result data(Map<String,Object> data){
        this.data=data;
        return this;
    }
}
