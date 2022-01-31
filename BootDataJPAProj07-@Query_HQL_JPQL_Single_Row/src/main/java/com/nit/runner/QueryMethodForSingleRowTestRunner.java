package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.repository.IMovieRepository;

@Component
public class QueryMethodForSingleRowTestRunner implements CommandLineRunner {

	@Autowired
	private IMovieRepository repo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("===================Single Row  Select Operations For entity class Object ============");
	    Movie movie=repo.fetchMovieDetailsByName("83");  //canot use for each bcz single record is return type(Movie)
	    if(movie!=null)
	        System.out.println("Movie Details of 83 are :- "+movie);
	    else
	    	System.out.println("There is No Movie Found For the Given Name...");
	    
	      System.out.println();
	    System.out.println("===================Single Row  Scalar operation for Selecting Multipe Specific column values  ============");
	     Object obj= repo.fetchMovieDataByName("sanak");
	     //convert obj to ressult of object array
	     Object result[]=(Object[])obj;  //converting one obj to obj array
	     //print details
	     for(Object val:result) {
	    	 System.out.print(val+" ");
	     }//for
	     System.out.println();
	     System.out.println("===================Single Row  Scalar operation for Selecting One Specific column values  ============");
	     Object year=repo.fetchMovieYearByName("83");
	     System.out.println("Year of the 83 movie is :- "+year);
	     
	}// run
}// class
