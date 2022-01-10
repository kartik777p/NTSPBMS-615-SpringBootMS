package com.nit.service;

import java.util.List;

import com.nit.entity.Movie;

public interface IMovieMgmtService {
	  //get all the recods
	public List<Movie> getAllRecords();
	//delete multipe record at same time by list of ids
	public String deleteAllRecordsBasedOnThereIds(List<Integer> ids);
	//findAllByIds
	public List<Movie> findAllByIds(List<Integer> ids);
	//findAllWithSort
	public List<Movie> searchMoviesByMovie(Movie movie,boolean order,String... props); //in netflix when we are watching movie...there is an one option
                                                                                                                                                                                // watch other movie like this.....this method is like that....
	                                                                                                                                                             // if we passed some details here...this method will check for the some details in Db sw(All  passed Details must match) if there..then it will return that matches object as list of records
 //find movie by their id
	public Movie findMovieById(Integer id);
	//deleteAll Movies 
	public String deleteAllMovies();
	//deleteAllInbatch with Iterable
	public String deleteAllMoviesInBatch(List<Movie> movies);
	//findAllWith(Sort)
	public List<Movie> getAllMoviesBySort(boolean order,String... props);
	//saveAll
	public String registerAllMovies(List<Movie> movies);
}
