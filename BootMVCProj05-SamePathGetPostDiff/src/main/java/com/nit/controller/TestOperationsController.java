package com.nit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test-operations")
public class TestOperationsController {
  
	@GetMapping("/all")
	public String showHomePage() {
		System.out.println("TestOperationsController.showHomePage()");
		return "show_report1";
	}
}
