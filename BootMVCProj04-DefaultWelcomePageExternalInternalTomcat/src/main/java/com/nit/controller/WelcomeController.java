package com.nit.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.nit.service.IWishMsgService;

@Controller
public class WelcomeController {
  
	@Autowired
	private IWishMsgService service;
	
	/* //display Home page without typing any URl
	@RequestMapping("/")        //No need of index.jsp as a welcome file AND main thing it will working on Both external Tomcat and Internal tomcat(Embedded)
	public String showHomePage() {
		//return LVN
		return "welcome";
	}//showHomePage	  */
	
	@RequestMapping
	public String showHomePage() {
		//return LVN
		return "welcome";
	}//showHomePage
	
	@RequestMapping("/wish")
	public String fetchWishMsg(Map<String,Object> map) {
		System.out.println("Shared Memory class name is :- "+map.getClass());
		//set values to map attr
		map.put("wMsg",service.genrateWishMsg());
		map.put("sDate",new Date());
		//return LVN
		return "show_result";
	}//fetchWishMsg
	
}//class
