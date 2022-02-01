package com.nit.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.Movie;

@Transactional //to enable tx mgmt since we are not using service class here
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    
	//update query
	@Modifying  
	@Query("update Movie set rating=:newRating where mName=:name")
	//return type integer bcz non select sql query return type is numric value
	public int updateRatingBasedOnThereName(Float newRating, String name);
	
	//delete
	@Modifying
	@Query("DELETE FROM Movie where year>=:startMid AND year<=:endMid")
	public int deleteMovieByYearRange(String startMid, String endMid);
	
} 
