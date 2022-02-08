package com.nit.runner;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import oracle.jdbc.OracleTypes;
 
			

				 /*	 Function
				CREATE OR REPLACE FUNCTION FX_GET_MOVIES_BY_RETINGS 
				(
				  STARTRATING IN NUMBER 
				, ENDRATING IN NUMBER 
				, CNT OUT NUMBER 
				) RETURN SYS_REFCURSOR AS 
				  details SYS_REFCURSOR; 
				BEGIN
				
				  SELECT COUNT(*) INTO CNT FROM sp_data_movie;
				   
				   OPEN details 
				   FOR SELECT MID,MNAME,YEAR FROM SP_DATA_MOVIE WHERE RATING>=STARTRATING AND RATING<=ENDRATING;
				   
				  RETURN details;
				END FX_GET_MOVIES_BY_RETINGS;
						
*/


@Component
public class CallingPLSQLTestFunctionTestRunner implements CommandLineRunner {
	 
	@Autowired
	private EntityManager manager;

	@Override
	public void run(String... args) throws Exception {
	  //get(unWrap) the session obj from EntityManager class
		Session session=manager.unwrap(Session.class);   //hibernate session 
		//work  with returningWork CallbackInterface base callback method
		  Object results[]= (String[]) session.doReturningWork(con->{    //lambda to execute method of returningWork interface 
			//write callable statement based logic to call function
			CallableStatement cs=con.prepareCall("{?=FX_GET_MOVIES_BY_RETINGS(?,?,?)}"); //2 in 1 out
			//register return,out param with jdbc type
			 cs.registerOutParameter(1, OracleTypes.CURSOR);
			 cs.registerOutParameter(4, Types.INTEGER);
			 //set values to IN param
			 cs.setFloat(2, 2.2f);
			 cs.setFloat(3, 5.5f);
			 //Call PL/SQL function 
			 cs.execute();
			 //gather result from out param
			 ResultSet rs=(ResultSet)cs.getObject(1);
			 //Create arrayList to hold values/records
			 List<Object> list=new ArrayList();
			 //process the resultSet
			 while(rs.next()) {
				 //bcz 3 details
				 Object record[] =new Object[3];
				 //assign value
				 record[0]=rs.getString(1);
				 record[1]=rs.getString(2);
				 record[3]=rs.getString(3);
				  //add to list
				 list.add(record);
			 }//while
			 
			 Object data[]=new Object[2]; //1st list 2nd count of record
			 //assign values
			 data[0]=list;
			 data[1]=cs.getInt(4);  //out param cnt value
			return data;
		});
		  //process the result
		  System.out.println("Movies in the given range :- ");
		  List<Object[]> ratingList=(List<Object[]>)results[0];
		  ratingList.forEach(md->{
			  for(Object val:md) {
				  System.out.print(val+" ");
				  System.out.println();
			  }
		  });
		  //get count of the record
		  int count=(Integer)results[1];
		  System.out.println("count of the record is :-"+count);
	}// run
}//class
