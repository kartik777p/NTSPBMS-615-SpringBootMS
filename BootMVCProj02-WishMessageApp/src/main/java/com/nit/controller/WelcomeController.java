package com.nit.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nit.service.IWishMsgService;

@Controller
public class WelcomeController {
  
	@Autowired
	private IWishMsgService service;
	
	//display Home page
	@RequestMapping("/home")
	public String showHomePage() {
		//return LVN
		return "welcome";
	}//showHomePage	
	
	@RequestMapping("/wish")
	public ModelAndView fetchWishMsg() {
		//Create ModelandView class Obj to send data from controller to view comp
		ModelAndView mav=new ModelAndView();
		//set data to MAV Obj
		mav.addObject("wMsg", service.genrateWishMsg());
		mav.addObject("sDate",new Date());
		//set view Name
		mav.setViewName("show_result");
		//return Mav
		return mav;
	}//fetchWishMsg
	
}//class
