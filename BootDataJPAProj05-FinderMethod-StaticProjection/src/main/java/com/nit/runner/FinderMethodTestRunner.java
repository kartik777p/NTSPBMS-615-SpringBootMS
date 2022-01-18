package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.projection.ResultView;
import com.nit.repository.IMovieRepository;

@Component
public class FinderMethodTestRunner implements CommandLineRunner {

	@Autowired
	private IMovieRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("----Static Scaler/Projection---------------");
		System.out.println();
		try {
			//use repo class 
			List<ResultView> list=repo.findByMidGreaterThanEqualAndMidLessThanEqual(48, 90);
			//print records
			//list.forEach(System.out::println);   //can't use this bcz inMemory proxy class.. so we have to gather data manually
			list.forEach(mv->{
				//get inMemory proxy class Name
				System.out.println("InMemoryProxy class Name :- "+mv.getClass());
				//print data of proxy class which we got
				System.out.println("Mid :- "+mv.getMid()+" Mname:- "+mv.getmName());
			}
		);
		}catch (Exception e) {
			e.printStackTrace();
		}
		}//run
}//class
