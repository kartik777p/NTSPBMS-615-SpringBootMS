package com.nit.test;



import java.util.Date;

import com.nit.commons.Employee;
import com.nit.commons.Student;

public class App {
	/*//Version 1
	// create one Generic method For All Objs <type>T
	public <T> T showDetails(Class<T> clazz) throws Exception {
		// craete obj of the given passed class
		return (T) clazz.getDeclaredConstructors()[0].newInstance(); // get the Array of declared cons and create the
																		// obj
																		// of the cons which is present in 0 Index
	}
	*/
	// create the obj of a class using o param cons only...
		public <T> T showDetails(Class<T> clazz) throws Exception { //if we want to  create obj of our choise type then ..passed that type to getDeclaredConsMethod(having that type) 
			return (T) clazz.getDeclaredConstructor(new Class[] {}).newInstance();  // here we are saying to declaredCons method that we have to create the obj of the class.. using 0-param cons only...
		 //type cast must be there bcz we have to convert to its specific type
		}
		
	public static void main(String[] args)throws Exception {
		App app = new App();
		//create student obj
    Student std=app.showDetails(Student.class); //pass student as a Java.lang.Class instnace
	System.out.println(std);
	System.out.println("-------------------------------");
	//create emp obj
	Employee emp=app.showDetails(Employee.class); //pass Employee as a Java.lang.Class instnace
	System.out.println(emp);
	System.out.println("-------------------------------");
/*	//version 1
   //create one pre-defined class obj which is having 0 param cons
	Date dt=app.showDetails(Date.class);   //here is the probelm we have mension that get the list of the declared cons and ten create 0 index and use that cons to craete obj
																				// but maybe in date class 0  index cons is not 0 param cons ....thats why will get exception..to solve this problem follow version 2
	System.out.println(dt);   */
	//Version 2
	 //create one pre-defined class obj which is having 0 param cons
		Date dt=app.showDetails(Date.class); 
		System.out.println(dt);
		System.out.println("-------------------------------");
	}
}
