package com.coursProject.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CoursprojetConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursprojetConfigServerApplication.class, args);
	}

}
