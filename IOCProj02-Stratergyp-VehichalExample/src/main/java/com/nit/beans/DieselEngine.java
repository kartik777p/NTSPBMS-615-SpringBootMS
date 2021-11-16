package com.nit.beans;

import org.springframework.stereotype.Component;

@Component("deisel")
public class DieselEngine implements Enggine {
   
	public DieselEngine() {
		System.out.println("DieselEngine :: 0-param constuctor ");
	}
	@Override
	public void start() {
	 System.out.println("DieselEngine Started.....");
	}

	@Override
	public void stop() {
		System.out.println("DieselEngine Stopped.....");
	}
}//class
