package com.nit.beans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("cng")
//@Primary
public class CNGEngine implements Enggine {
	
	public CNGEngine() {
		System.out.println("CNGEngine :: 0-param constuctor ");
	}

	@Override
	public void start() {
		System.out.println("CNGEngine Started............");
	}
	@Override
	public void stop() {
		System.out.println("CNGEngine Stopped............");
	}
}//class
