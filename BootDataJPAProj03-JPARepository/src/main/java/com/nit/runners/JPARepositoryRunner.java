package com.nit.runners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.service.IMovieMgmtService;

@Component
public class JPARepositoryRunner implements CommandLineRunner {
	
    //we have to use Service class here thats why we inject service class obj here
	@Autowired
	private IMovieMgmtService service;

	@Override
	public void run(String... args) throws Exception {
	/*	 System.out.println("===========JPA findAll() method ======");
		 try {
			 List<Movie> list=service.getAllRecords();
			 //print records
			 System.out.println("1.=====Using Inhanced For Loop=====");
			 for(Movie mv:list) {
				 System.out.println(mv);
			 }//for
			 System.out.println("2.=====Using For Each=====");
			 list.forEach(movie-> System.out.println(movie));
			 System.out.println("3.=====Using For Each+ Static method Ref=====");
			 list.forEach(System.out::println);
			 System.out.println("4.=====Using Stream +forEach=====");
			 list.stream().forEach(mv->System.out.println(mv));
			 System.out.println("5.=====Using Stream +forEach+Static method Ref=====");
			 list.stream().forEach(System.out::println);
		 }catch (Exception e) {
			e.printStackTrace();
		}//catch    */
	/*	System.out.println("==========DeleteByIdsInBatch(List<Integer> ids>=======");
		try {
			//create one ArrayList to Store List of id
			//List<Integer> ids=Arrays.asList(234,null);  //here null allowed(mutable list)
			List<Integer> ids=new  ArrayList<Integer>();
			ids.add(44);   //we can pass null also no exception will come
			ids.add(1);
			ids.add(null);
			//use service method here passing List or ids as args
			//String msg=service.deleteAllRecordsBasedOnThereIds(List.of(234,null));  exception  will come,,but of method Immutable list so we can not change once it created..thats why in of() null is not Available
			String msg=service.deleteAllRecordsBasedOnThereIds(ids);
			System.out.println(msg);
		}catch (Exception e) {
			e.printStackTrace();
		}//catch   */
	/*	System.out.println("==========findAllById(Iterable<Integer> ids>======="); 
		try {
			//Prepare list of of ids
			List<Integer> ids=new ArrayList<Integer>(Arrays.asList(46,53));  //wrong id no Exception //for null also no exception
			List<Movie> list=service.findAllByIds(ids);
			list.forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}       */
	/*	System.out.println("==========findAll(Example,Sort)======="); 
		try {
			//create movie obj having all details
			Movie movie=new Movie();
			//movie.setMid(100);     //if we comment mid and mname it will use Ratting and year as criteria value(Check query for refrence)
			//movie.setMName("Kadak");
			movie.setRating(4.4f);
			movie.setYear("2021");  //here and clause Applied..(Both Ratting And year must have the same as db ) so you passed info and Db saved info matches then that record is display
			//use service class by passing nesesary details
			List<Movie> list=service.searchMoviesByMovie(movie, true,"mName");  //it uses entity class non null values and uses is criteria value
			//print details
			list.forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}    */
	/*	System.out.println("==========getById(Id)=======");
		try {
			System.out.println("48 :- id based record is :- "+service.findMovieById(48));
		}catch (Exception e) {
			e.printStackTrace();
		}    */
	/*	System.out.println("==========deleteAllInbatch()=======");
		try {
			System.out.println(service.deleteAllMovies());
		}catch (Exception e) {
			e.printStackTrace();
		}    */
	/*	System.out.println("==========deleteAllInbatch(iterable)=======");
		try {
			//create list of movies obj
			List<Movie> list=new ArrayList<Movie>();
			//create movie obj 
			Movie movie=new Movie();
			//add details
			//movie.setMid(81); //other than Db values allowed  //null allowed here (version2)
			//movie.setMid(null); //version 1-->null not allowed 
			movie.setMName("pushpa");
			movie.setRating(4.1f);
			movie.setYear("2017");
			//add record to list
			list.add(movie);
			//call sevice method by passing list of movie obj
			String msg=service.deleteAllMoviesInBatch(list);
			System.out.println(msg);
		}catch (Exception e) {
			e.printStackTrace();
		}    
		*/
	/*	System.out.println("========FindAll(Sort)===========");
		try {
			List<Movie> list=service.getAllMoviesBySort(true, "year");
			list.forEach(mv->{
				System.out.println(mv);
			});
		}catch (Exception e) {
			e.printStackTrace();
		}//catch   */
	/*	System.out.println("========SaveAll(List>===========");
		try {
			//create list to hold movies obj
			List<Movie> list=new ArrayList<Movie>();
			//add elements to list
			//list.add(new Movie("sanak","2018" ,3.5f));
		//	list.add(new Movie("khuda Hafiz","2019" ,3.4f));
			//use service class by sending list of movie class obj
			String msg=service.registerAllMovies(list);
			System.out.println(msg);
		}catch (Exception e) {
			e.printStackTrace();
		}   */
	}//run
}// class
