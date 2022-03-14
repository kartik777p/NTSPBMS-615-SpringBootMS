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
public class WelcomeController {
 
	
	@RequestMapping
	public String showHomePage() {
		//return LVN
		return "welcome";
	}//showHomePage
	
	//@RequestMapping(value="/report",method = RequestMethod.GET)
	@GetMapping("/report")
	public String showReportForGet() {
		return "show_report1";
	}//showReportForGet
	
	//@RequestMapping(value="/report",method = RequestMethod.POST)
	@PostMapping("/report")
	public String showReportForPost() {
		return "show_report2";
	}//showReportForPost
	
		
}//class
