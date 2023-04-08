package com.sustech.user_service.conroller;
import com.sustech.global.entity.Result;
import com.sustech.user_service.service.impl.UserLoginServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("用户账户测试模块")
@RestController
@RequestMapping("/user/account")
public class AccountController {
    @Autowired
    UserLoginServiceImpl userLoginService;

    @ApiOperation(value = "登录接口", notes = "具体方法未实现")
    @PostMapping("login")
    public Result login(String username, String password){
        boolean result = userLoginService.login(username,password);
        if(result) return Result.ok();
        return Result.error();
    }

    @ApiOperation(value = "注册接口", notes = "具体方法未实现")
    @PostMapping("register")
    public Result register(){
        return Result.error();
    }

}
