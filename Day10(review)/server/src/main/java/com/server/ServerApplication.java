package com.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.server.service.AdminService;

@SpringBootApplication
public class ServerApplication {

	@Autowired
	private AdminService adminService;
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}
}
