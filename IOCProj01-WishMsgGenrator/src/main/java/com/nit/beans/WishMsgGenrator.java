package com.nit.beans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMsgGenrator {
    
	@Autowired
	private LocalDateTime sysDate;
	
	public WishMsgGenrator() {
		System.out.println("WishMsgGenrator:: 0-param cons");
	}
	//B.logic method
	public String genrateWishMsg(String user) {
		int hrs=0;
		//get hours of the day
		hrs=sysDate.getHour(); //24 format
		 if(hrs<12)
			   return "Good Morning "+user;
		 else if(hrs < 16)
			 return "Good AfterNoon "+user;
		 else if(hrs < 19)
			 return "Good Evening  "+user;
		 else 
			 return "Good Night "+user;
	}//method
}//class
