package com.nit.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nit.entity.Movie;

@Transactional //to enable tx mgmt since we are not using service class here
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    
	//native SQL query
   @Modifying //Compulsory to write  ...if we do not write will get ORA-01002: fetch out of sequence Exception
	@Query(value = "INSERT INTO SP_DATA_MOVIE VALUES(MID_SEQ.NEXTVAL,?,?,?)" ,nativeQuery = true)
	public int registerMovie(String name,Float rating, String year);
	
	} 