package com.nit.beans;

import org.springframework.stereotype.Component;

@Component("petrol")
public class PetrolEngine implements Enggine {
    
	public PetrolEngine() {
		System.out.println("PetrolEngine :: 0-param constuctor ");
	}
	@Override
	public void start() {
		System.out.println("PetrolEngine Started..........");
	}
	@Override
	public void stop() {
		System.out.println("PetrolEngine Stopped..........");
	}
}//class
