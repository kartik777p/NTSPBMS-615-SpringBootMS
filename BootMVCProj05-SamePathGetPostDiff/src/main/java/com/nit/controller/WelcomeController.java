package com.nit.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nit.service.IWishMsgService;

@Controller
//@RequestMapping("/wish-operation")
public class WelcomeController {
 
	
	@RequestMapping
	public String showHomePage() {
		//return LVN
		return "welcome";
	}//showHomePage
	
	//@RequestMapping(value="/report",method = RequestMethod.GET)
	@GetMapping("/report")
	public String showReportForGet() {
		System.out.println("WelcomeController.showReportForGet()");
		return "show_report1";
	}//showReportForGet
	
	//@RequestMapping(value="/report",method = RequestMethod.POST)
	@PostMapping("/report")
	public String showReportForPost() {
		System.out.println("WelcomeController.showReportForPost()");
		return "show_report2";
	}//showReportForPost
	
	@GetMapping("/forward")
	public String showReportByForwoding() {
		System.out.println("WelcomeController.showReportByForwoding()");
		//return "forward:wish-operation/report";  //same class
		//return "forward:report"; 
		return "forward:test-operations/all";  // Forwarding req to another class hander method
	}
	
	@GetMapping("/redirect")
	public String showReportByRedirect() {
		System.out.println("WelcomeController.showReportByRedirect()");
		//return "redirect:wish-operation/report";  //same class
		return "redirect:report"; 
		//return "redirect:test-operations/all";  // redirect req to another class hander method
	}//showReportForGet
}//class
