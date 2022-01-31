package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    
	// Agregate function
	//single function 
	@Query("Select max(rating) from Movie")
	public Float fetchMovieByMaxRating();
	
	@Query("select max(rating),min(rating),avg(rating),count(*),sum(year),avg(year) from Movie")
	public Object agregateDataOnMovies();
} 
