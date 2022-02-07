package com.nit.runner;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nit.entity.Movie;

							  /*   procedure
			create or replace PROCEDURE P_AUTH 
			(
			  USER IN VARCHAR2 
			, PASS IN VARCHAR2 
			, RESULT OUT VARCHAR2 
			) AS 
			   cnt NUMBER;
			BEGIN
			 SELECT COUNT(*) into cnt FROM USERLIST WHERE UNAME=USER AND PWD=PASS;
			 IF(cnt<>0)THEN
			   RESULT:='Valid creadentils';
			 ELSE
			   RESULT:='InValid creadentils';
			   END IF;
			END P_AUTH;   */



@Component
public class CallingPLSQLProcedureTestRunner implements CommandLineRunner {
	 
	@Autowired
	private EntityManager manager;

	@Override
	public void run(String... args) throws Exception {
		
		//create StoredProcedureQuery obj having PL_SQL Procedure
		StoredProcedureQuery query=manager.createStoredProcedureQuery("P_Auth"); //only entity class we have 
		//regiter param 
		query.registerStoredProcedureParameter(1,String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2,String.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(3,String.class, ParameterMode.OUT);
		//set values to PLSQL procudure param
		query.setParameter(1,"kartik");
		query.setParameter(2,"Kartik@123");
		//execute PL/SQL procedure(return single record)
		String result= (String) query.getOutputParameterValue(3); //3 is out param index  
		//display result
		System.out.println(result );
	}// run
}
