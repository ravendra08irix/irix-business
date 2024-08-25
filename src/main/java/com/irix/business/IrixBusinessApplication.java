package com.irix.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class IrixBusinessApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(IrixBusinessApplication.class, args);
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		return builder.sources(IrixBusinessApplication.class);
//	}
}
