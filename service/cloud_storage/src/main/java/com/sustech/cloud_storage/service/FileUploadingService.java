package com.sustech.cloud_storage.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadingService {
    String upload(MultipartFile file);
}
