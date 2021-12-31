package com.nit.service;

import java.util.List;
import java.util.Optional;

import com.nit.entity.Movie;

public interface IMovieMgmtService {
	//save movie
   public String registerMovie(Movie movie);
   //get movies count
   public Long fetchMoviesCount();
   //check movie exists or not
   public Boolean checkMovieById(Integer id);
   //get all movies 
   public Iterable<Movie> fetchAllMovies();
   //getch all movies by id
   public Iterable<Movie> fetchAllMoviesById(List<Integer> mids);
   //find movie by its id  
   public Movie fetchMovieById(Integer id);
   //same method with diff Flawor
   public Optional<Movie> gatherMovieById(Integer id);    //if record is there gets Optional<movie> otherwise will get optional obj having empty movie
   //saveAll movie at same time
   public String groupMovieRegistration(List<Movie> moviesList);
   //update some details of movie(partial Object updation)
   public String updateMovieDetails(Integer mid, String year, Float ratting);
   //update movie  (Complete object updation)
   public String updateMovie(Movie movie);
   //remove movie by id
   public String removeMovieById(Integer mid);
   //delete by Object
   public String removeMovie(Movie movie);
   //remove all movies(no-param)
   public String removeAllMovies();
   //remove all movies by id
   public String removeAllMoviesById(List<Integer> ids);
   //delete all movies which record i passed
   public String removeAllMoviesByObjects(List<Movie> movies);
}
