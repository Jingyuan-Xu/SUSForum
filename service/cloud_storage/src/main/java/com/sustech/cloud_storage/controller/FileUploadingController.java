package com.sustech.cloud_storage.controller;

import com.sustech.cloud_storage.service.FileUploadingService;
import com.sustech.global.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/cloud_storage/file")
@Api(value = "接口测试类", tags = "云储存测试类")
public class FileUploadingController {
    @Autowired
    private FileUploadingService fileUploadingService;
    @ApiOperation(value = "上传文件至云端")
    @PostMapping("uploading")
    public Result upload(MultipartFile file){
        System.out.println("----------------");
        String url= fileUploadingService.upload(file);
        Map<String,Object> data = new HashMap<>();
        data.put("url",url);
        return Result.ok().data(data);
    }

}
