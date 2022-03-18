package com.nit.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nit.model.Product;

@Controller
public class DataRenderingController {

	@GetMapping("/render")
	public String passDataToViewComps(Map<String,Object> map) {
		System.out.println("Shared memoery class name is :- "+map.getClass());
		//Create Model class Obj having some data (Genarally this Obj will come from Db)
		Product product=new Product();
		product.setId(101);
		product.setName("chair");
		product.setQty(3);
		product.setRate(600F);
		System.out.println("Model class data :- "+product);
		//set product to Model Attrs
		map.put("productData", product);
			//return LVN
		return "show_result";   
	}
	
}
