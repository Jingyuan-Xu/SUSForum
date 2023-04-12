package com.sustech.main_service.service;


import com.sustech.main_service.entity.MailRequest;

public interface MailService {
    void sendMail(MailRequest mailRequest);
}
