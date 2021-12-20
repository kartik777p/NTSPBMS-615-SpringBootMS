package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.nit.model.CaronaPetient;

@Component("OraDao")
@Profile({"uat","prod"})
public class OraclePetientDAOImpl implements PetientDAO {
	private static final String GET_PETIENTS_RECORDS = "SELECT * FROM CARONA_PETIENT_MINIPROJ WHERE CITY IN(?,?,?) ORDER BY CITY";
	@Autowired
	private DataSource ds;
    public OraclePetientDAOImpl() {
		System.out.println("OraclePetientDAOImpl:: 0-param Constuctor");
	}
	
	@Override
	public List<CaronaPetient> getPetients(String city1, String city2, String city3) throws Exception {
		System.out.println("DataSource Name :- "+ds.getClass());
		List<CaronaPetient> list = null;
		try (Connection con = ds.getConnection(); PreparedStatement ps = con.prepareStatement(GET_PETIENTS_RECORDS)) {
			// set values to query param
			ps.setString(1, city1);
			ps.setString(2, city2);
			ps.setString(3, city3);
			// execute query
			try (ResultSet rs = ps.executeQuery()) {
				list = new ArrayList<CaronaPetient>();
				while (rs.next()) {
					CaronaPetient c = new CaronaPetient();
					c.setId(rs.getLong(1));
					c.setPName(rs.getString(2));
					c.setAge(rs.getInt(3));
					c.setHospitalName(rs.getString(4));
					c.setAdmit_Date(rs.getDate(5));
					c.setDischarge_Date(rs.getDate(6));
					c.setCity(rs.getString(7));
					// add to list
					list.add(c);
				} // while
			} // try2
		} // try1
		catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}//
}//class
