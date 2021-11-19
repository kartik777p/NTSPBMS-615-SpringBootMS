package com.nit;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nit.bean.WishMassageGenrator;

@SpringBootApplication
public class BootProj01DependancyInjectionApplication {

	// create preDefined class obj
	@Bean("cal")
	public Calendar createCalender() {
		// get calender(subclas) class obj
		return Calendar.getInstance();
	}

	public static void main(String[] args) {
		// get ioc conatainer obj ref
		ApplicationContext ctx = SpringApplication.run(BootProj01DependancyInjectionApplication.class, args);
		// get target class obj
		WishMassageGenrator wmg = ctx.getBean("wmg", WishMassageGenrator.class);
		// call target class b method
		String msg = wmg.getWishmsg("kartik");
		// display msg
		System.out.println(msg);
	}
}
