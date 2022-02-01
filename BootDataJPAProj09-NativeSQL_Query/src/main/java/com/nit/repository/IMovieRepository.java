package com.nit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nit.entity.Movie;

@Transactional // spring related translational
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
    
	//native SQL query
	   @Modifying //Compulsory to write  ...if we do not write will get ORA-01002: fetch out of sequence Exception
		@Query(value = "INSERT INTO SP_DATA_MOVIE VALUES(MID_SEQ.NEXTVAL,?,?,?)" ,nativeQuery = true)
		public int registerMovie(String name,Float rating, String year);
	   
	   @Query(value = "SELECT SYSDATE FROM DUAL" , nativeQuery = true)
	   public String fetchSysDate();
	   
	   @Query(value = "create table temp1(col1 number(5))", nativeQuery = true)
	   @Modifying  //Compulsory since it is not select query.. if not wriitter will get negativeArrayIndex Size 1 exception
	   public int createTableTemp();
}
