package com.nit.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehical")
public class Vehical {
	//Engg property
	@Autowired
	@Qualifier("enggType")
	private Enggine engg;
	//cons
	public Vehical() {
		System.out.println("Vehical::- 0-param constuctor ");
	}
	//B.logic
	public void Journey(String src,String dest) {
	//start engg
		engg.start();
		System.out.println("Engine Started at :-"+src);
		System.out.println("Journey is going on............");
		//stop engg
		engg.stop();
		System.out.println("Engine Stopped at :-"+dest);
	}//b.logic
}//class
