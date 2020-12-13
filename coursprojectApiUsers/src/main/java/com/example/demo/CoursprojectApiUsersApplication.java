package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
@EnableDiscoveryClient //Relate this Client with Eureka server! & step2 = propretiesConfig
public class CoursprojectApiUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursprojectApiUsersApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder pwdEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	

}
