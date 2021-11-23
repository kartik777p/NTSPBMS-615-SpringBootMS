package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("empDAO")
public class EmployeeDAO {
	private static final String COUNT_RECORD="SELECT COUNT(*) FROM EMP";
  //autocfgs 
	@Autowired       
	private DataSource ds;
	
	public int getEmpsCounts()throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int status=0;
		//get class name
		System.out.println("Loaded class Name is:- "+ds.getClass());
		//get connection obj
		con=ds.getConnection();
		//create ps Obj 
		ps=con.prepareStatement(COUNT_RECORD);
		//execute query
		rs=ps.executeQuery();
		//process the resultSet
		//only one record thats why if else
		if(rs.next()) {
			status=rs.getInt(1);
		}//if
		//return status
		return status;
	}//method
}//class
