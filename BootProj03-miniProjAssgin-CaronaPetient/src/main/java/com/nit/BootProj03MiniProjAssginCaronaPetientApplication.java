package com.nit;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nit.controller.PetientController;
import com.nit.model.CaronaPetient;

@SpringBootApplication
public class BootProj03MiniProjAssginCaronaPetientApplication {

	public static void main(String[] args) {
		List<CaronaPetient> list = null;
		ApplicationContext ctx = SpringApplication.run(BootProj03MiniProjAssginCaronaPetientApplication.class, args);
		// get target class obj
		PetientController con = ctx.getBean("pController", PetientController.class);
		// call b method
		try {
			list = con.getPetints("akola", "pune", "mumbai");
			// print petint details here
			list.forEach(p -> {
				System.out.println("Id:- " + p.getId() + " Name:- " + p.getPName() + " Age:- " + p.getAge()
						+ " HospitalName:- " + p.getHospitalName() + " AdmitDate:- " + p.getAdmit_Date()
						+ " DischargeDate:- " + p.getDischarge_Date() + " City:- " + p.getCity());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
