package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.repository.IMovieRepository;

@Component
public class QueryMethodForSingleRowAgregateFunctionTestRunner implements CommandLineRunner {

	@Autowired
	private IMovieRepository repo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("============Single agrgate function===========");
		System.out.println(repo.fetchMovieByMaxRating());
		System.out.println();
		
		System.out.println("============Multiple agrgate function===========");
		Object result[]=(Object[])repo.agregateDataOnMovies(); //convert to obj array
		//display
		System.out.println("max rating :- "+result[0]);
	  System.out.println(" Min rating :- "+result[1]);
	  System.out.println(" Avg rating :- "+result[2]);
	  System.out.println(" Count of records :- "+result[3]);
	  System.out.println(" Sum of year :-"+result[4]);
	  System.out.println(" Avg year :-"+result[5]);
	}// run
}// class
