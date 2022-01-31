package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    
	//====================Entity Query Selecting All Values of the Db Tabel======================
	@Query("From Movie WHERE mname=:name") //assuming there are unique names(no duplicate name)
     public Movie fetchMovieDetailsByName(String name);
	
	//====================Singlerow  Scaler Query giving Specific  multiple coulm values of the Db Tabel======================
	@Query("select mid,mName,year from Movie WHERE mname=:name")
	public Object fetchMovieDataByName(String name);
	
	//====================Single row Scaler Query giving Specific  one coulm values of the Db Tabel======================
@Query("Select year from Movie Where mname=:name")   
	public Object fetchMovieYearByName(String name);

} 
