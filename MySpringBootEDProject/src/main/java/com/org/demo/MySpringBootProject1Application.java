package com.org.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MySpringBootProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootProject1Application.class, args);
	}

}
