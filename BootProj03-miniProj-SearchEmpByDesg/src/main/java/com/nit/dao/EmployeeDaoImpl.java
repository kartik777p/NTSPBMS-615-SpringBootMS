package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.model.Employee;

@Repository("empDao")
public class EmployeeDaoImpl implements EmployeeDao {
	private static final String GET_EMPS_BY_DESG = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?)";
	// inject datasource here
	@Autowired
	private DataSource ds;

	@Override
	public List<Employee> fetchEmpsByDesg(String desg1, String desg2, String desg3) throws Exception {
		List<Employee> list = null;
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_DESG)) {
			// set values to query param
			ps.setString(1, desg1.toUpperCase());
			ps.setString(2, desg2.toUpperCase());
			ps.setString(3, desg3.toUpperCase());
			// execute query
			try (ResultSet rs = ps.executeQuery()) {
				list=new ArrayList<Employee>();
				// process the resultSet
				while (rs.next()) {
					Employee emp = new Employee();
					emp.setEmpNo(rs.getLong(1));
					emp.setEmpName(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setSal(rs.getDouble(4));
					// add to list
					list.add(emp);
				} // while
			} // try2
		} // try1
		catch (SQLException se) {
			se.printStackTrace();
			throw se; // exception rethrowing
		} catch (Exception e) {
			e.printStackTrace();
			throw e; // exception rethrowing
		}
		// return list
		return list;
	}// method
}// class
