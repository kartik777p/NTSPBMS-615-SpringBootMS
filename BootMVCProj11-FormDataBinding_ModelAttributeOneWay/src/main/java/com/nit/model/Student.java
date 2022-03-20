package com.nit.model;

import lombok.Data;

@Data
public class Student {
 //same property name must be given as input text box name
	private Integer sno;
	private String sname;
	private String sadd;
	private Float avg;
	
	Student(){
		System.out.println("Student.Student()");
	}//cons
}//class
