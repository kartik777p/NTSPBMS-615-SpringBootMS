package com.nit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    
	//sub query
	//get 2nd max rating(one or more record)
	
	@Query("from Movie where rating=(select max(rating) from Movie)")
	public List<Movie> getSecoundMaxRatingMovie();
} 
