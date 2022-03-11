package com.nit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCotroller {
	
	@RequestMapping("/home")
	public String homeController() {
		//return LVN
		return "welcome";
	}//homeController

}
