package com.nit.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServletCreatedObjectTestController {
	/* USING @Autowired 
  //version 1
	//autowired servlet container created object
	@Autowired
	private ServletConfig config;
	@Autowired
	private ServletContext context;
	@Autowired
	private HttpSession session;
	
	@GetMapping("/details")
	public String getDetailsOfObjects() {
		System.out.println("Servlet created config obj class name is :- "+config.getClass());
		System.out.println("Servlet created context obj class name is :- "+context.getClass()+" And Context path of the Application is :- "+context.getContextPath()+" And Servlet Context name is :-  "+context.getServletContextName());
	    System.out.println("Servlet created session obj class name is :- "+session.getId());
	  return "welcome";
	}   */
	
	/* NOT ALLOWED 
	 //there  no provison to take context and config as method param but we can take ServletSession 
	@GetMapping("/details2")
	public String getDetailsOfObject(HttpSession session,ServletConfig config,ServletContext context) {
		System.out.println("Servlet created config obj class name is :- "+config.getClass());
		System.out.println("Servlet created context obj class name is :- "+context.getClass()+" And Context path of the Application is :- "+context.getContextPath()+" And Servlet Context name is :-  "+context.getServletContextName());
	    System.out.println("Servlet created session obj class name is :- "+session.getId());
	  return "welcome";
	}  */
	
	//POSSIBLE
	@GetMapping("/details2")
	public String getDetailsOfObject(HttpSession session) {
	    System.out.println("Servlet created session obj class name is :- "+session.getId());
	  return "welcome";
	}//getDetailsOfObject
	
	
	
	
}
