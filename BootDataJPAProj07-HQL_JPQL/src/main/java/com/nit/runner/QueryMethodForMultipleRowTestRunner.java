package com.nit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.repository.IMovieRepository;

@Component
public class QueryMethodForMultipleRowTestRunner implements CommandLineRunner {

	@Autowired
	private IMovieRepository repo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("=======JPQL AND HQL QUERY EXECUTION==================");
		/*------------------------------------------- @Query method for Selecting all colms values of DB table-----------------------------------------------------*/
	 /*  System.out.println("---------------fetchMoviesById------------------");
	   List<Movie> list=repo.fetchMoviesById(50,100);
	 list.forEach(System.out::println);  */
		
	/*	System.out.println("---------------searchMoviesByMname------------------");
		List<Movie> list=repo.searchMoviesByMovieNames("Pushpa","83","Sanak");
		list.forEach(System.out::println);  */
		
		/*------------------------------------------- Scalar @Query method for Selecting Specifics colms values of DB table-----------------------------------------------------*/
	
		
		/*	System.out.println("-----------------getDetailsOfMoviesByRattingAndYears------------------------");
		List<Object[]> list=repo.getDetailsOfMoviesByRattingAndYears(4.7f,"2021","2018","2019");
		// list.forEach(System.out::println);  //here to string method will execute from object class thats why hashcode is comming
        //gather values from obj array and print it manually		
		//version1
		//list.forEach(row->System.out.println("id :- "+row[0]+" Name :-"+row[1]+" Year :-"+row[2]));
		//version 2
		list.forEach(row->{
			for(Object val:row) {
				System.out.print(val+" ");
			}//for
			System.out.println();
		});    */
		   
          /*------------------------------------------- Scalar @Query method for Selecting Specifics One colms values of DB table-----------------------------------------------------*/
      /* System.out.println("------------------------------getMoviesByYearRange------------------");
      repo.getMoviesByYearRange("2021","2099").forEach(row->{
    	  System.out.println("Name:- "+row);
      });   */
	}// run
}// class
