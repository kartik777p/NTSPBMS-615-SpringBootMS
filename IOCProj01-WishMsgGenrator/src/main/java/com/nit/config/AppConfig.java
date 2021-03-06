package com.nit.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.nit")
public class AppConfig {
	
	public AppConfig() {
		System.out.println("AppConfig:;0-param constuctor ");
	}
	@Bean("sysDate")
	public LocalDateTime createLDT() {
		return LocalDateTime.now(); // static factory methof of that class gives date and time
	}// createLDT
	
}// class
