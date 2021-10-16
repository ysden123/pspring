package com.stulsoft.pspring.spring.runners;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRunnersApplication {

	public static void main(String[] args) {
		System.out.println("==>main");
		SpringApplication.run(SpringRunnersApplication.class, args).close();
	}

}
