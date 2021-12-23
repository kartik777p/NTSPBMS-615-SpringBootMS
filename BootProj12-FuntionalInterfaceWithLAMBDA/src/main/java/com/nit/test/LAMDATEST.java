package com.nit.test;

import com.nit.service.Arithmatic;

public class LAMDATEST 
{
    public static void main( String[] args )
    {
       //style 1       (Simple one)
    	/*Arithmatic ar=(int a, int b)->{
    		int c=a+b;
    		return c;
    	};
    	System.out.println("Sum ::- "+ar.add(10,20));   */
    	
    	//style 2       (direct return st)
    	/*Arithmatic ar=(int a, int b)->{
    		return a+b;
    	};
    	System.out.println("Sum ::- "+ar.add(10,20));  */
    	
    	 //style 3     
    	/*Arithmatic ar=(int a, int b)-> a+b;    //one line return st also optional 
    	System.out.println("Sum ::- "+ar.add(10,20));  */
    	
    	//style 4
    	  /* Arithmatic ar=(a,b)-> a+b;    //here param type also optinal
    	System.out.println("Sum ::- "+ar.add(10,20));   */
    	
    	//style 5
    	Arithmatic ar=(x,y)-> x+y;    //here param name can be changed 
    	System.out.println("Sum ::- "+ar.add(10,20)); 

    }
}
