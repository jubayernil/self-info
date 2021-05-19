package com.oihello.selfinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class SelfInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelfInfoApplication.class, args);
	}

}
