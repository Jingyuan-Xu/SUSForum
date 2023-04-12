package com.sustech.main_service.controller;
import com.sustech.global.entity.Result;
import com.sustech.main_service.entity.MailRequest;
import com.sustech.main_service.service.MailService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Api(tags = "发送邮件接口")
@RestController
@RequestMapping("/mail")
@CrossOrigin
public class MailController {
    @Autowired
    private MailService mailService;

    @PostMapping("/sendMail")
    public Result SendSimpleMessage(@RequestBody MailRequest mailRequest) {
        mailService.sendMail(mailRequest);
        return Result.ok();
    }
}