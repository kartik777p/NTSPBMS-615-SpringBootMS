package com.nit.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;
 
			/*  //procedure
			create or replace PROCEDURE P_GET_MOVIES_BY_YEAR_RANGE 
			(
			  STARTYEAR IN VARCHAR2 
			, ENDYEAR IN VARCHAR2 
			, DETAILS OUT SYS_REFCURSOR 
			) AS 
			BEGIN
			  open details for
			   SELECT MID,MNAME,RATING,YEAR FROM SP_DATA_MOVIE 
			   WHERE YEAR>=startyear AND YEAR<=endyear
			  ;
			END P_GET_MOVIES_BY_YEAR_RANGE;    */

@Component
public class CallingPLSQLTestRunner implements CommandLineRunner {
	 
	@Autowired
	private EntityManager manager;

	@Override
	public void run(String... args) throws Exception {
	   //create StoredProcedureQuery obj having PL_SQL procedure
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_GET_MOVIES_BY_YEAR_RANGE",Movie.class); //(Entity class Name )please give me movie class obj
	   //Register params of PL_SQL procedure with jdbc(java) dataType
    query.registerStoredProcedureParameter(1,String.class,ParameterMode.IN);
    query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
    query.registerStoredProcedureParameter(3,Movie.class,ParameterMode.REF_CURSOR); //2nd param bcz movie obj will come 
    //set values to IN PARAM
    query.setParameter(1, "2010");
    query.setParameter(2, "2020");
    //Call PL_SQL Procedure //get the result list
    List<Movie> movies=query.getResultList();
    //print record one by one
    movies.forEach(System.out::println);  
	}// run

}
