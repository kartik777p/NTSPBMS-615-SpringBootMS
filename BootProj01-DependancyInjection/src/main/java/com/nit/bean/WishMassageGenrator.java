package com.nit.bean;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMassageGenrator {
	@Autowired
	private Calendar calender;

	// b.method
	public String getWishmsg(String user) {
		int hrs = calender.get(Calendar.HOUR_OF_DAY);
		if (hrs <= 12)
			return "Good Morning ::-" + user;
		else if (hrs <= 15)
			return "Good AfterNoon ::-" + user;
		else if (hrs <= 19)
			return "Good Evening ::-" + user;
		else
			return "Good Night ::-" + user;
	}// method
}// class
