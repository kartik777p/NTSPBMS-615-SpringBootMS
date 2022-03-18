package com.nit.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataRenderingController {

	@GetMapping("/render")
	public String passDataToViewComps(Map<String,Object> map) {
		System.out.println("Shared memoery class name is :- "+map.getClass());
		//set values to Model Attrs
		//Array Type
		map.put("favColors",new String[] {"Red","Yellow","Pink","Blue"});
		//List Type
		map.put("nickNames", List.of("Kartik","Shubh","Maddy","Shiv","Rishabh"));
		//Set Type
		map.put("phoneNumbers",Set.of(888888888,777777777,666666666,444444444));
		//Map Type
		map.put("idDetails",Map.of("AdharNo",224760296701L,"panNo","FIBPP374M"));
		//return LVN
		return "show_result";   
	}
	
}
