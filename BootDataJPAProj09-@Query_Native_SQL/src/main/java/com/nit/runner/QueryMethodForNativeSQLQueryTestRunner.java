package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.repository.IMovieRepository;

@Component
public class QueryMethodForNativeSQLQueryTestRunner implements CommandLineRunner {

	@Autowired
	private IMovieRepository repo;

	@Override
	public void run(String... args) throws Exception {
	   System.out.println("=======INSRT QUERY===========");	
	   int count=repo.registerMovie("Sanak",4.1f, "2.9");
	   System.out.println(count==0?"Movie not Registed ":"Movie is Registed");
	}// run
}// class
