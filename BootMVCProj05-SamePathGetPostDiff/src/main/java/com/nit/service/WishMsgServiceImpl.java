package com.nit.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Service
public class WishMsgServiceImpl implements IWishMsgService {

	@Override
	public String genrateWishMsg() {
		// get local date and time
		LocalDateTime ldt = LocalDateTime.now();
		// get hrs of the day
		int hrs = ldt.getHour();
		//genrate wish msg
		if(hrs<=12)
			 return "Good Morning ";
		else if(hrs<=16)
			return "Good Afternoon";
		else if(hrs<=20)
			 return "Good Evening";
		else
			return "Good Night ";

	}//genrateWishMsg
}//class
