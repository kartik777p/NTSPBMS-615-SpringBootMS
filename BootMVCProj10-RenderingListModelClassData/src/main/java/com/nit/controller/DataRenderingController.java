package com.nit.controller;

import java.util.ArrayList;
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
		//product 1
		Product product=new Product();
		product.setId(101);
		product.setName("chair");
		product.setQty(3);
		product.setRate(600F);
		//product 2
		Product product2 = new Product();
		product2.setId(102);
		product2.setName("Freez");
		product2.setQty(4);
		product2.setRate(500F);
		//product 3
		Product product3 = new Product();
		product3.setId(103);
		product3.setName("Air collar");
		product3.setQty(4);
		product3.setRate(400F);
		//Create one ArrayList and ad this product therr
		List<Product> products=new ArrayList();
		products.add(product);
		products.add(product2);
		products.add(product3);
		System.out.println("Available data in the List is :- "+products.toString());
		//set List of products to Model Attrs
		map.put("productList", products);
			//return LVN
		return "show_result";   
	}
	
}
