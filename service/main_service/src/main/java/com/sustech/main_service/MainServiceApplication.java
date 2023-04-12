package com.sustech.main_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@ComponentScan("com.sustech")
@CrossOrigin
@MapperScan("com.sustech.main_service.mapper")
public class MainServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MainServiceApplication.class, args);
	}
}
