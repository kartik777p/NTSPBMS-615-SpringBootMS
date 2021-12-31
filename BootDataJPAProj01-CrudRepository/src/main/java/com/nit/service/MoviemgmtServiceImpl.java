package com.nit.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nit.entity.Movie;
import com.nit.repository.IMovieRepository;

@Service("movieService")
public class MoviemgmtServiceImpl implements IMovieMgmtService {
     
	@Autowired     //injects the dynamically inmemory proxy class obj
	private IMovieRepository repo;
	
	@Override
	public String registerMovie(Movie movie){
		//to get inmemory proxy class name and its super interfaces
		System.out.println("InMemory proxy class name :- "+repo.getClass()+" its Super Interfaces :- "+Arrays.toString(repo.getClass().getInterfaces()));    //  getInterfaces return array of interfaces and we are converting them to one string for printing       
		Movie m1=null;
		   System.out.println("MoviemgmtServiceImpl.registerMovie()");
		   System.out.println("before calling repo values are :- "+movie);   //entity class obj  with no @id(Genrated) values
		   //use repo here 
		   m1=repo.save(movie);
		   System.out.println("After calling repo values are :- "+m1);     //return entity class obj having @id(Genrated) value
		return "Movie has been Registed with the given id :- "+m1.getMid();
	}//method
	
	@Override
	public Long fetchMoviesCount() {
		System.out.println("MoviemgmtServiceImpl.fetchMoviesCount()");
		//to get inmemory proxy class name and its super interfaces
				System.out.println("InMemory proxy class name :- "+repo.getClass()+" its Super Interfaces :- "+Arrays.toString(repo.getClass().getInterfaces()));    //  getInterfaces return array of interfaces and we are converting them to one string for printing
		     System.out.println("------------------------------------------------");
		     //get the all mehod list of which implemeted by  Proxy class 
		 	System.out.println("Methods or proxy class  :- "+Arrays.toString(repo.getClass().getDeclaredMethods()));
				return repo.count();
	}//count
	
	@Override
	public Boolean checkMovieById(Integer id) {
		return repo.existsById(id);
	}
	
	@Override
	public Iterable<Movie> fetchAllMovies() {
		return repo.findAll();
	}
	
	@Override
	public Iterable<Movie> fetchAllMoviesById(List<Integer> mids) {
		return repo.findAllById(mids);
	}
	/*
	 //here record is available return it otherwise throw exception
	@Override
	public Movie fetchMovieById(Integer id) {
		Movie mv=null;
		//get Optional obj 
		Optional<Movie> opt=repo.findById(id);
		//check optional obj is present or not
		if(opt.isPresent()) 
		            return opt.get();
		else
			  throw new IllegalArgumentException("There is no Movie Avaible for given id :-");	
	}    */
	
	/*   //here record is available return it otherwise throw exception
			@Override
			public Movie fetchMovieById(Integer id) {
				//one line statement (if found return it otherwise throw exception
				//no need o .get() calling here it will be calling and getting and returning obj internally
				return repo.findById(id).orElseThrow(()->new IllegalArgumentException("No Movie found for given id"));
			}     */
	
	//here if record is not there  then empty Entity obj will comes with its defult value ..no exception will come here
	@Override
	public Movie fetchMovieById(Integer id) {
		return repo.findById(id).orElse(new Movie()); //if record is there gives record with its data
		}																						 //otherwise Empty entity will return 
	@Override
	public Optional<Movie> gatherMovieById(Integer id) {
		//get optional obj  
		Optional<Movie> opt=repo.findById(id);
	/*	//check Optional is empty of not
		if(opt.isEmpty())
			//if empty then return empty optional obj
			   return Optional.empty();
		else
			//otherwise return optional obj having Movie obj(which we got)
		       return opt ;    */
		//Instread of Writing in 5 line use Ternary Oprator
		return opt.isEmpty()?Optional.empty() : opt;
	}
	@Override
	public String groupMovieRegistration(List<Movie> moviesList) {
		List<Integer> savedIds=new ArrayList<Integer>();
		Iterable<Movie> savedMovies=repo.saveAll(moviesList);
		//here i dont want to return all saved movie obj instread of that i want to return all saved movies Ids..thats why we have to save All movies Ids  into another list
		if(savedMovies!=null && ((List<Movie>) savedMovies).size()>0) {   //in iterable size method not there thats why we have to cast to List
			//if moviesAre there then gather ids from savedMovies and add that ids to savedIds 
			savedMovies.forEach(m->{
				savedIds.add(m.getMid()); //saved ids
			});
		}//if
		//return list of ids as a string
		return savedIds.toString()+"Movies Are Saved....";
	}//groupMovieRegistration
	
	//Version 1---partial update --- Enduser should be enter movie id
	@Override
	public String updateMovieDetails(Integer mid, String year, Float ratting) {
		//first we have to check for the given id record is Available or not using optional class bcz find by id return type is ioptional obj
		Optional<Movie> opt=repo.findById(mid);
		//now check record is there or not if there then update otherwise show msg there is no record
		if(opt.isPresent()) {
			//get the record from the Optional obj
			Movie movie=opt.get();
			//update its data
			movie.setYear("1999");
			movie.setRating(4.0f);
			//save modified obj to database
			repo.save(movie);  //always call marge(-) method internally to update the record
			return "The given id:- "+movie.getMid()+" based Movie is Updated ";
		}
		return "For the given Movie id There is no movie Available....";
	}//method
	
	//version 2- here also enduser must enter id value (available or not available)
		@Override
		public String updateMovie(Movie movie) {
			//check for the given id movie is Availble or not
			Optional<Movie> opt=repo.findById(movie.getMid());
			//check condication
			if(opt.isPresent()) {
				//save the given obj ---
				repo.save(movie);
				return movie.getMid()+" :- id based movie updated Sucesfully.....";
			}//if
			else
				 return "For the given id:- "+movie.getMid()+" No movie found to Update ";
		}//method
		
    /*	 
     //Version3- Record must be Available (like Grid option at the end edit button bcz if record is there then only that record edit option is there)
	@Override
	public String updateMovie(Movie movie) {
		//gather the record from the param and save to db
		repo.save(movie);                     //here probelm is if record is there then update it of record not found then ot will insert the record with new id value...here we can not say 
		return "Movie Updated";                                                                 //record is not there
	}     */
	
		//version 1- if we dont know obj is availble or not then use this  bcz if record there wil get record if ot there will get msg/or Exception (recomanded version1) 
	@Override
	public String removeMovieById(Integer mid) {
		//check movie is there or not for given id...if have get movie obj ...if not there ..we wil get exception
		Movie movie=repo.findById(mid).orElseThrow(()->new IllegalArgumentException("For the given id:-"+mid +" No Movie Found"));
		//if record is there then delete it
		repo.deleteById(mid);
		return mid+" :- id based record is deleted Sucesfully..........";
	}
	//version 2- if we dont know obj is availble or not then use this  bcz if record there wil get record if ot there will get msg/or Exception  (alternate to version 1)
	@Override
	public String removeMovie(Movie movie) {
	//here we can not use ternary operator bcz it exprect boolean value as a expression...but here delete return type in void...
		//return repo.delete(movie)?movie.getMid()+" :- id based movie is deleted":movie.getMid()+" :- id based movie is not found to delete ";
			//find the movie is there or not for the given movid id
		Optional<Movie> opt=repo.findById(movie.getMid());
		//check condition
		if(opt.isPresent()) {
			//delete the movie which we got
			repo.delete(movie);
			return movie.getMid()+" :- id based movie is deleted";
		}
		else
		      return movie.getMid()+" :- id based movie is not found to delete ";
	}
	
	 /*  //version 3- go for when we know id/record is 100% available...
	  @Override
	public String removeMovie(Movie movie) {                 //problem with this code is if record is there then it will delete that record
		//delete record directly from the database            //but suppose record is not there is there no provision to say that record is not there (bcz delete return type is void)
		repo.delete(movie);
		return movie.getMid()+" :- based record is deleted sucesfully.........";
	}    */
	
	@Override
	public String removeAllMovies() { 
		//get count how many records are there
		Long count=repo.count();
		if(count!=0) {
			//delete all record
			repo.deleteAll();
			return count+":- No of record is deleted..";
			} 
		else
			 return "There is no record to delelet ";
	} 
	
	@Override
	public String removeAllMoviesById(List<Integer> ids) {
		//1st check for all ids must not be null  (we can not handel it so we go for exception propagation and in cleint we will handle it
	/*	for(Integer id : ids) {     //if we pass null value from there will get null ppinter exception to solve this use contains method
			if(id==null)
				 return "Given ids must not be null.....";
		}//for    */
		//to check waeter ids conatins any null values or not
	/*	if(ids.contains(null)) {
			  return "Given ids must not be null....";
		}   */
		//get all the record of the given ids
		Iterable<Movie> itr=repo.findAllById(ids); //we have ids so we use this method
		//get size of iterator
		Integer count=((List<Movie>) itr).size();  //casting req bcz size() is not there in iterator..
		//if all ids is there then check for 2nd condition to check all its element
		if(ids.size()!=0 && ids.size()==count) {   //given ids and fetched record from the Db based on the id should match then only delete 
			//delete all records by passing ids
			repo.deleteAllById(ids);
			return ((List<Movie>) itr).size()+" No of record is deleted...";
		}
		else
			return "No ids are given to delete  OR maybe You have passed some Wrong ids which is not there"; 
	}
	
	@Override
	public String removeAllMoviesByObjects(List<Movie> movies) {
		
		return null;
	}
	
	
}//class
