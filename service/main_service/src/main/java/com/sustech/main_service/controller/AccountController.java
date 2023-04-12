package com.sustech.main_service.controller;

import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.User;
import com.sustech.main_service.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Api("用户账户测试模块")
@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录接口")
    @PostMapping("login")
    public Result login(String username, String password) {
        System.out.println("in login");
        User user = userService.getByUsername(username);

        if (user != null && password.equals(user.getPassword())){
            Map<String,Object> data = new HashMap<>();
            data.put("id",user.getId());
            return Result.ok().code(200).data(data);
        }

        return Result.error().message("No such user or invalid username or password");
    }

    @ApiOperation(value = "注册接口")
    @PostMapping("register")
    public Result register(@RequestBody User user) {
        User dbUser = userService.getByUsername(user.getUsername());
        if (dbUser != null) {
            return Result.error().message("User exists, please retry again");
        }
        String msg = "Success to register";
        if (user.getPassword() == null) {
            return Result.error().code(6000).message("no password");
        }
        user.setNickName(user.getNickName());
        user.setRole(1);
        if (userService.addUser(user)) {
            Map<String, Object> map = new HashMap<>();
            map.put("data", user);
            return Result.ok().code(200).message(msg).data(map);
        }
        return Result.error();
    }

    @PostMapping("revise")
    @ApiOperation(value = "修改用户信息")
    public Result reviseInfo(String id, String username, String password, String nick_name, String email, String avatar, String background) {
        if (username == null) username = "";
        if (password == null) password = "";
        if (nick_name == null) nick_name = "";
        if (email == null) email = "";
        if (avatar == null) avatar = "";
        if (background == null) background = "";
        boolean bool = userService.reviseInfo(id, username, password, nick_name, email, avatar, background);
        if (!bool) return Result.error().code(5000).message("invalidInfo");
        return Result.ok().code(200);
    }

}
