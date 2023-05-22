package com.sustech.global.handler;

import com.sustech.global.entity.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result unknownError(){
        return Result.error()
                .message("未被定义的错误")
                .code(1000);
    }
}