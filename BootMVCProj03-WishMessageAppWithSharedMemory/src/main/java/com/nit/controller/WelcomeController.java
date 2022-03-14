package com.nit.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	
	
	/*// VERSION 1 (NOT GOOD)
	 1)Working with ModelAndView is bad bcz We have to return ModelAndView As the return type
	 2)We have to create ModelAndView Object manually
	 3)It is created its own seprate shared memory which is not Recomanded
	 4)It is spring Specific (can not mo
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
	}//fetchWishMsg  */
	
	/*------------------------------NOT RECOMANDED TO USE USING SHARED MEMORY --------------------------------*/
	
	/* VERSION 2 (NOT GOOD--> ONE OF ITS SUBCLASS(ModelMap) REFFER ITS SUPER CLASS(BindingAwareModelMap) OBJ REF)
	 1)Good bcz it is using Shared Memory which is created by DS
	 2)But Non recommended bcz it is spring specific (can be used only in Spring)
	 3)No need of creating any extra object like ModelAndView
	 @RequestMapping("/wish")
		public String fetchWishMsg(ModelMap map) {     //ModelMap class
		System.out.println("Shared Memory Obj class Name is ::- "+map.getClass());
		 //set attr values
		 map.addAttribute("wMsg", service.genrateWishMsg());
		 map.addAttribute("sDate", new Date());
		 //return LVN
		 return "show_result";
		}//fetchWishMsg  */
	
	/* VERSION 3 (NOT GOOD INTERFACE(MODEL) REF VARIBALE IMPLEMENTS ONE OF ITS IMPL CLASS REF OBJ )
	  1)Good bcz it is using Shared Memory which is created by DS
	 2)But Non recommended bcz it is spring specific (can be used only in Spring)
	 3)No need of creating any extra object like ModelAndView
	 @RequestMapping("/wish") 
		public String fetchWishMsg(Model model) {   //Model interface
		System.out.println("Shared Memory Obj class Name is ::- "+model.getClass());
		 //set attr values
		 model.addAttribute("wMsg", service.genrateWishMsg());
		 model.addAttribute("sDate", new Date());
		 //return  LVN
		 return "show_result";
		}//fetchWishMsg   */
	 
	/* NOT RECOMANDED TO USE BCZ IT IS NOT SPRING SPECIFIC
	  
	@RequestMapping("/wish")
	public String fetchWishMsg(HashMap<String,Object> map) {        //HashMap class
		System.out.println("Shared Memory Obj class Name is ::- "+map.getClass());
	//set attr
	 map.put("wMsg", service.genrateWishMsg());
	 map.put("sDate",new Date());
	 //return LVN
	 return "show_result";
	}//fetchWishMsg 
	 */
	
	/*------------------------------NOT TO USE USING SHARED MEMORY --------------------------------*/
	
	/*
	 * GOOD (RECOMANDED TO USE) 1) Using Shared memory which is created by Ds 2)No
	 * need of creating extra object 3)it is not Spring Specific bcz Map given in
	 * JDK itself
	 */
	  
	 @RequestMapping("/wish")
		public String fetchWishMsg(Map<String,Object> map) {   //Map Interface
		//set attr
		 map.put("wMsg", service.genrateWishMsg());
		 map.put("sDate",new Date());
		 //return LVN
		 return "show_result";
		}//fetchWishMsg  */
	
	/*--------------------BUT I DONT WANT TO USE DS CREATED SHARED MEMORY I WANT TO CREATE MY OWN SHARED MEMORY AND USE THET MEMORY*/
	
	
	/* //1)Not Recomanded to use bcz its recomanded to use DS created own SharedMemory
	 @RequestMapping("/wish")
		public ModelMap fetchWishMsg() {   
		 //create BindingAwareModelMap class obj
		 ModelMap map=new BindingAwareModelMap();  //Super class ref veriable hold its sub class obj
		//set attr
		 map.put("wMsg", service.genrateWishMsg());
		 map.put("sDate",new Date());
		 //Here no need of of returning view name(there is no provision) and we can not set view name also like setView name
		 //return BindingAwareModelMap class obj
		 return map;
		}//fetchWishMsg      */
	
	/*
	// Not Recomanded 
	@RequestMapping("/wish")
		public Model fetchWishMsg() {   
		 //create BindingAwareModelMap class obj
		 Model model=new BindingAwareModelMap();  //Super class ref veriable hold its sub class obj
		//set attr
		 model.addAttribute("wMsg", service.genrateWishMsg());
		 model.addAttribute("sDate",new Date());
		 //Here no need of of returning view name(there is no provision) and we can not set view name also like setView name
		 //return BindingAwareModelMap class obj
		 return model;
		}//fetchWishMsg  */
	/*
	  //Not Recomanded
	  @RequestMapping("/wish")
		public Map<String,Object> fetchWishMsg() {   
		 //create BindingAwareModelMap class obj
		 Map<String,Object> map=new BindingAwareModelMap();  //Super class ref veriable hold its sub class obj
		//set attr
		 map.put("wMsg", service.genrateWishMsg());
		 map.put("sDate",new Date());
		 //Here no need of of returning view name(there is no provision) and we can not set view name also like setView name
		 //return BindingAwareModelMap class obj
		 return map;
		}//fetchWishMsg  */
	
	/*
	//Q)WHAT HAPPED I WE TAKE HANDER METHOD RETURN TYPE IS VOID(it directly send res to broswer)
	//ANS->It willl take req path logical view name by excluding the slash(/) we are not returning the obj thats why values not coming
	 @RequestMapping("/wish")
		public void fetchWishMsg() {   
		 //create BindingAwareModelMap class obj
		 Map<String,Object> map=new BindingAwareModelMap();  //Super class ref veriable hold its sub class obj
		//set attr
		 map.put("wMsg", service.genrateWishMsg());
		 map.put("sDate",new Date());
		}//fetchWishMsg   */
	
	/*
	//Q)WHAT HAPPED I WE TAKE HANDER METHOD RETURN Value IS Null(it directly send res to broswer)
	//ANS->It willl take req path logical view name by excluding the slash(/) we are not returning the obj thats why values not coming
	 @RequestMapping("/wish")
		public Model fetchWishMsg() {   
		 //create BindingAwareModelMap class obj
		 Map<String,Object> map=new BindingAwareModelMap();  //Super class ref veriable hold its sub class obj
		//set attr
		 map.put("wMsg", service.genrateWishMsg());
		 map.put("sDate",new Date());
		 //return null
		 return null;
		}//fetchWishMsg  */
	
	/*-----------------------------RETURN RESPONSE DIRECT TO BROWSER(USEFULL FOR FILE DOWNLODING NO NEED TO INVOLVING VIEW RESOLVER)-----------------------*/
	/*
	 @RequestMapping("/wish")
		public Model fetchWishMsg(HttpServletResponse res)throws Exception {  
		 //use service
		 String msg=service.genrateWishMsg();
		 //get printwriter obj from res object
		 PrintWriter pw=res.getWriter();
		 //set res content type
		 res.setContentType("text/html");
		 //print res 
		 pw.println("<h1>WishMessage is :- "+msg+"</h1>");
		 pw.println("<h1>Todays date is :- "+new Date()+"</h1>");
		 //return null
		 return null;
		}//fetchWishMsg   */
	
	
}//class
