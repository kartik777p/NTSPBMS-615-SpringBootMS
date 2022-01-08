package com.nit.runners;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
import com.nit.service.IMovieMgmtService;

@Component
public class CRUDRepoRunnerTest implements CommandLineRunner {
	
    //we have to use Service class here thats why we inject service class obj here
	@Autowired
	private IMovieMgmtService service;
	
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("----------------------------Save The Record --------------------------------------");
		//create movie obj to save data
		Movie movie=new Movie();
		//set values to movie obj
		movie.setMName("Pushpa");
		movie.setRating(4.8f);
		movie.setYear("2k21");
		//use service class to do further opration(saving obj)
		try {
			System.out.println(service.registerMovie(movie));
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	/*	System.out.println("--------------------------Count Movies ------------------------------------------------");
		try {
			System.out.println("Record Count is :- "+service.fetchMoviesCount());
		}catch (Exception e) {
			e.printStackTrace();
		}   */
		
	/*	System.out.println("-------------Check Movie Exists by Id");
		try {
			System.out.println("is any Movie Availble Which Id is 2 :- ? "+service.checkMovieById(2));
		}catch (Exception e) {
			e.printStackTrace();
		}    */
		
	/*	 System.out.println("-----------------For FindAll() method --------------------");
		try {
			Iterable<Movie> list=service.fetchAllMovies();
			System.out.println("Option:- 1...........using Inhanced for loop/forEach loop.............");
			for(Movie movie:list) {
				System.out.println(movie);
			}
			System.out.println("Option:- 2...........using For each with 2 line.............");
			list.forEach(mv->{
				System.out.println(mv);
			});
			System.out.println("Option:- 3...........using For each with 1 Line.............");
			list.forEach(m-> System.out.println(m));
			System.out.println("Option:- 4...........using Static method Ref .............");
			list.forEach(System.out::println);
			System.out.println("Option:- 5...........using ForEach+ stream Api()+Static method ref .............");
			//list.stream();
			//we directly can not use stream method here  in Iterator there is no Stream method thats why we have to convert Iterator to List then use stream
			Arrays.asList(list).stream().forEach(System.out::println);  
			
			System.out.println("Option:- 6...........using ForEach+Static method ref .............");
			Arrays.asList(list).stream().forEach(System.out::println);  
		}catch (Exception e) {
			e.printStackTrace();
		}    	    */
	 	System.out.println("-----------------For FindAllByIds() method --------------------");
	   try {
		   //create empty list
			List<Integer> list = new ArrayList<>();
			// add ids to ArrayList which movie you want to fetch
			list.add(1);
			list.add(3);
			// use service class here by sending list of Movies id
			//1st Way 
			//Iterable<Movie> movis=service.fetchAllMoviesById(List.of(1,2));  //from java 9 (Unmodifiable list) once created its content will not be changed
			//2nd Way 
			//Iterable<Movie> movis=service.fetchAllMoviesById(Arrays.asList(1,2));    // if we supplied values is not there ten it doest thow any exception only just skip that id 
			//System.out.println(movis);
			//3rd way Simple and State forword
			Iterable<Movie> movies=service.fetchAllMoviesById(list);
			System.out.println("Option 1-------------Enhanced for Loop");
			for(Movie mv:movies) {
				System.out.println(mv);
			}
			System.out.println("Option 2-------------Using ForEach with 2 Lines");
			movies.forEach(mv->{
				System.out.println(mv);
			});
			System.out.println("Option 3-------------Using ForEach with single stetament");
			movies.forEach(mv->System.out.println(mv));
			System.out.println("Option 4-------------Using ForEach + Static Metod Ref");
			movies.forEach(System.out::println);
			System.out.println("Option 5-------------Using ForEach +Stream Api() + Static Metod Ref");
			Arrays.asList(movies).stream().forEach(System.out::println);
			System.out.println("Option 6-------------Using ForEach + Static Metod Ref");
			Arrays.asList(movies).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}     
	   /*     System.out.println("---------FindById(-) ");
		try {
			System.out.println("Movie details is :- "+service.fetchMovieById(2));
		}catch (Exception e) {
			e.printStackTrace();
		}    */
		
	/*	System.out.println("---------GatherById(-) Optional<Movie> Or Empty Optional ");
		try {
			//use service class here and get optional obj having record or Empty
			Optional<Movie> opt=service.gatherMovieById(5);
			//process the record
			if(!opt.isEmpty())
				System.out.println("1 record is :- "+opt.get());
			else
				System.out.println("Record Not Found ");
		}catch (Exception e) {
			e.printStackTrace();
		}      */
	/*	System.out.println("---------SaveAll(-)------------ ");
		//create list of Records
		try {
			//Create ArrayList obj Having List of Movies Objes
			List<Movie> lists=new ArrayList<Movie>(List.of(new Movie( "suryvanshi","2021", 4.7f),new Movie( "Rowdy Rathod","2014", 4.5f),new Movie( "*MR Vijay","2022", 4.9f),new Movie( "83","2023", 4.3f),new Movie( "KGF","2021", 4.7f)));
		//   add record to arrayList  (option 2)
		//	lists.add(new Movie( "KGF","2021", 4.7f));
		//	lists.add(new Movie( "kGF2","2021", 4.5f));
		//	lists.add(new Movie( "83","2023", 4.3f));
		//	lists.add(new Movie( "*MR Vijay","2022", 4.9f));
		//	lists.add(new Movie( "geeta Gowindam","2026", 4.1f));    
			
			//use service method by passing list of moves class of objs
			String msg=service.groupMovieRegistration(lists);
			System.out.println(msg);
		}catch (Exception e) {
			e.printStackTrace();
		}       */
		
	/*	System.out.println("---------Save(-) For Update Operation------------ ");
		try {
			 String msg=service.updateMovieDetails(27,"1900", 2.1f);
			 System.out.println(msg);
		}catch (Exception e) {
			e.printStackTrace();
		}       */
		
   	/*	 //Option 1 and 2 both
    System.out.println("---------Save(-) For Update Operation------------ ");
		try {
			Movie movie=new Movie("RRR","2018",3.9f);
			//set mid
			movie.setMid(1);   
			String msg=service.updateMovie(movie);
			System.out.println(msg);
		}catch (Exception e) {
			e.printStackTrace();
		}        */
	/*	System.out.println("---------deleteById(-) method------------ ");
		try {
			//use service class here by sending mid 
			String msg=service.removeMovieById(21);
			System.out.println(msg);
		}catch (Exception e) {
			e.printStackTrace();
		}    */
	
	/*	System.out.println("---------deletebyObject() method------------ ");
		try {
			Movie m1=new Movie();    //we can not pass null here bcz we have given all properties as nonnull in entity class(Lombock)
			//set id                                           //other values is there or not there does not matter,but id must be there
			m1.setMid(3);							//bcz it internally delete the record by id
			String msg=service.removeMovie(m1);
			System.out.println(msg);
		}catch (Exception e) {
			e.printStackTrace();
		}      */ 
	/*	System.out.println("---------deleteAll() method------------ ");
		try {
			//use service class here
			String msg=service.removeAllMovies();
			System.out.println(msg);
		}catch (Exception e) {
			e.printStackTrace();
		}   */
		
	/*	System.out.println("---------deleteAllByIds() method------------ ");
		try {
			String msg=service.removeAllMoviesById(List.of(46));   
			System.out.println(msg);
		}catch (NullPointerException npe) {
			System.out.println("Ids must not be null");
			npe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}     */
	}// run      
}// class
