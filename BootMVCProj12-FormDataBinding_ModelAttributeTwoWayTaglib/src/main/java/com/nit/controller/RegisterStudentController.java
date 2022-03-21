package com.nit.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nit.model.Student;

@Controller
public class RegisterStudentController {
 
	
	@GetMapping("/")
	public String showWelcomePage() {
		//return LVN
		return "welcome";
	}//showWelcomePage
	
	@GetMapping("/register")
	public String showFormPage(@ModelAttribute("stud")Student std) {  //std obj created with its initial values and that value is visible in form page 
		//Give some default values
		std.setAvg(88f);
		//return LVN
		return "register_student";
	}//showFormPage
	
	
	@PostMapping("/register")
	public String registerStudent(Map<String, Object> map,@ModelAttribute   ("stud")  Student st) {
		//No need of setting data explicitly to model class obj bcz  already data there in req scope putted by Ds
		System.out.println("stud data is :- "+st);
		// return LVN
		  return "student_details";                                                         
	}//registerStudent
}//class

