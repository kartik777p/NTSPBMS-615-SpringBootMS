package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.repository.IMovieRepository;

@Component
public class QueryMethodForNonSelectOprationTestRunner implements CommandLineRunner {

	@Autowired
	private IMovieRepository repo;

	@Override
	public void run(String... args) throws Exception {
		/*  System.out.println("=================update Non sql Query=============");
		  int count=repo.updateRatingBasedOnThereName(5.0f, "83");
		  System.out.println(count+" No of record is Updated..."); */
		  System.out.println();
		  System.out.println("===========delete query===========");
		  int count=repo.deleteMovieByYearRange("2014","2016");
		  System.out.println(count+" No of record is Deleted...");
		  
	}// run
}// class
