package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.repository.IMovieRepository;

@Component
public class QueryMethodForSubQueryTestRunner implements CommandLineRunner {

	@Autowired
	private IMovieRepository repo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("============SubQuery===========");
		List<Movie> list=repo.getSecoundMaxRatingMovie();
		list.forEach(System.out::println);	
	}// run
}// class
