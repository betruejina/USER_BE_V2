package com.tamchack.tamchack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TamChackApplication {

	public static void main(String[] args) {
		System.out.printf("TEST");
		SpringApplication.run(TamChackApplication.class, args);
	}
}
