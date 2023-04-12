package com.sustech.main_service.controller;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.User;
import com.sustech.main_service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api("用户账户测试模块")
@RestController
@RequestMapping("/user_service/account")
public class AccountController {
//    @Autowired
//    UserLoginServiceImpl userLoginService;
//
//    @ApiOperation(value = "登录接口", notes = "具体方法未实现")
//    @PostMapping("login")
//    public Result login(String username, String password){
//        boolean result = userLoginService.login(username,password);
//        if(result) return Result.ok();
//        return Result.error();
//    }
//
//    @ApiOperation(value = "注册接口", notes = "具体方法未实现")
//    @PostMapping("register")
//    public Result register(){
//        return Result.error();
//    }

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录接口")
    @PostMapping("login")
    public Result login(@RequestParam String username, String password) {
        User user = userService.getByUsername(username);
        if (user != null && password.equals(user.getPassword()))
            return Result.ok().code(200);
        return Result.error();
    }

    @ApiOperation(value = "注册接口")
    @PostMapping("register")
    public Result register(@RequestBody User user) {
        User dbUser = userService.getByUsername(user.getUsername());
        if (dbUser != null) {
            return Result.error().message("User exists, please retry again");
        }
        String msg = "";
        if (user.getPassword() == null) {
            user.setPassword("123456");
            msg = "No password. Provided 123456";
        }
        user.setNickName(user.getNickName());
        user.setRole(1);
        userService.save(user);
        Map<String, Object> map = new HashMap<>();
        map.put("data", user);
        return Result.ok().code(200).message(msg).data(map);
    }
}