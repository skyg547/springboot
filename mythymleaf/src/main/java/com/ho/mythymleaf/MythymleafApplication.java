package com.ho.mythymleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class MythymleafApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(MythymleafApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
//		SpringApplication.run(MythymleafApplication.class, args);
	}

}
