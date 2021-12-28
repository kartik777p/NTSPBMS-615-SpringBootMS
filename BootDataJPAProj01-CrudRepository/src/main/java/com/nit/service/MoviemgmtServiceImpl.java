package com.nit.service;

import java.util.Arrays;

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
}//class
