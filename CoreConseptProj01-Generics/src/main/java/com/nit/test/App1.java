package com.nit.test;



import java.sql.Date;

import com.nit.commons.Employee;
import com.nit.commons.Person;
import com.nit.commons.Student;

public class App1 {
	//here only subclass of the Person class only allowed...
	public <T extends Person> T showDetails(Class<T> clazz)throws Exception {
		return clazz.getDeclaredConstructor(new Class[] {}).newInstance();
	}
	 public static void main(String[] args)throws Exception {
		App1 app1=new App1();
		Student std=app1.showDetails(Student.class);
		System.out.println(std);
		System.out.println("----------------------------");
		Employee emp=app1.showDetails(Employee.class);
		System.out.println(emp);
		System.out.println("----------------------------");
		//now we will try one pre-defined class obj which is not subclass of person
		//Date dt=app1.showDetails(Date.class);//not allowed here...bcz only person and it sub class is allowed here
	}
}