package com.skeleton.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkeletonApplication {

	public static void main(String[] args) {
		System.out.println("Salutare");
		SpringApplication.run(SkeletonApplication.class, args);
	}
}
