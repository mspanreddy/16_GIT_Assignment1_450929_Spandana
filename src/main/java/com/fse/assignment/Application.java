package com.fse.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.fse.assignment" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

