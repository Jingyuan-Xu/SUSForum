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
import java.util.Random;

@Api(tags = "用户账户测试模块")
@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {
    @Autowired
    private UserService userService;
    @ApiOperation(value = "登录接口")
    @PostMapping("login")
    public Result login(String username, String password) {
        User user = userService.getByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            Map<String,Object> map = new HashMap<>();
            map.put("user",user);
            return Result.ok().code(200).data(map);
        }
        return Result.error().message("No such user or invalid username or password");
    }

    @ApiOperation(value = "注册接口")
    @PostMapping("register")
    public Result register(String username, String password, String nick_name, String email) {
        User user = new User();
        user.setId(String.valueOf(new Random().nextInt(Integer.MAX_VALUE)));
        user.setUsername(username);
        user.setPassword(password);
        user.setNick_name(nick_name);
        user.setEmail(email);
        user.setRole(1);
        User dbUser = userService.getByUsername(username);
        if (dbUser != null) {
            return Result.error().message("User exists, please try again.");
        }
        if (user.getPassword() == null) {
            return Result.error().code(6000).message("No password.");
        }
        if (userService.addUser(user)) {
            Map<String,Object> map = new HashMap<>();
            map.put("user",user);
            return Result.ok().code(200).message("Success to register.").data(map);
        }
        return Result.error().message("Fail to add user");
    }

    @PostMapping("revise")
    @ApiOperation(value = "修改用户信息")
    public Result reviseInfo(String id, String username, String password, String nick_name, String email, String avatar, String background) {
        User user = userService.getByUserId(id);
        if (user == null) {
            return Result.error().message("No such user");
        }
        if (username == null || password == null) {
            return Result.error().message("Missing username or password");
        }
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail((email != null) ? email : "");
        user.setNick_name((nick_name != null) ? nick_name : "");
        user.setAvatar((avatar != null) ? avatar : "");
        user.setBackground((background != null) ? background : "");
        if (userService.reviseInfo(user)) {
            return Result.ok().code(200);
        }
        return Result.error().code(5000).message("Fail to modify");
    }

}
