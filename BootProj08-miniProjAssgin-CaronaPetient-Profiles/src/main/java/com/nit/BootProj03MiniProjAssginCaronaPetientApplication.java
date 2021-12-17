package com.nit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nit.controller.PetientController;
import com.nit.model.CaronaPetient;

@SpringBootApplication
public class BootProj03MiniProjAssginCaronaPetientApplication {
     
	@Bean("c3p0Ds")
	@Profile({"uat"})  //enable for uat profile
	public ComboPooledDataSource c3p0Ds()throws Exception {
		System.out.println("BootProj03MiniProjAssginCaronaPetientApplication.c3p0Ds()");
		ComboPooledDataSource cds=new ComboPooledDataSource();
		cds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		cds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		cds.setUser("SYSTEM");
		cds.setPassword("SYSTEM");
		return cds;
	}
	
	public static void main(String[] args) {
		List<CaronaPetient> list = null;
		ApplicationContext ctx = SpringApplication.run(BootProj03MiniProjAssginCaronaPetientApplication.class, args);
		// get target class obj
		PetientController con = ctx.getBean("pController", PetientController.class);
		// call b method
		try {
			list = con.getPetints("akola", "pune", "mumbai");
			// print patint details here
			list.forEach(p -> {
				System.out.println("Id:- " + p.getId() + " Name:- " + p.getPName() + " Age:- " + p.getAge()
						+ " HospitalName:- " + p.getHospitalName() + " City:- " + p.getCity());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
