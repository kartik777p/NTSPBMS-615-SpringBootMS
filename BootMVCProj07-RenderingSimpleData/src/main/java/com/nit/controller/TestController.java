package com.nit.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping("/render")
	public String passDataToViewComps(Map<String,Object> map) {
		System.out.println("Shared memoery class name is :- "+map.getClass());
		//set values to Model Attrs
		map.put("name","Kartik Pastapure");
		map.put("age",23);
		//return LVN
		return "show_result";
	}
	
}
