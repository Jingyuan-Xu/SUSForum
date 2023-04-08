package com.sustech.topic_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan("com.sustech")
@CrossOrigin
@MapperScan("com.sustech.topic_service.mapper")
@EnableDiscoveryClient
public class TopicServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TopicServiceApplication.class, args);
    }

}
