package com.shark.springboot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//如果basePackages在主包下,则会被@EnableAutoConfiguration探测到,无需添加以下注解
@EnableJpaRepositories(basePackages = "com.shark.springboot.dal.dao")

//如果basePackages在主包下,则会被@EnableAutoConfiguration探测到,无需添加以下注解
@EntityScan(basePackages = "com.shark.springboot.dal.model.entity")
@SpringBootApplication(scanBasePackages = "com.shark.springboot")
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
}
