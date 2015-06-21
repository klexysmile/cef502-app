package com.timetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.timetable.model.Faculty;
import com.timetable.util.DbUtil;

public class FacultyDao {
	private Connection connection;
	
	public FacultyDao(){
		connection = DbUtil.getConnection();
	}
	
	public void addFaculty(Faculty fac){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("insert into faculties(location, name, short_code"
					+ ") values (?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, fac.getLocaton());
			preparedStatement.setString(2, fac.getName());
			preparedStatement.setString(3, fac.getShortCode());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateFaculty(Faculty fac){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("update faculties set location = ?, name = ?, short_code = ?"
					+ " where id = ?");
			// Parameters start with 1
			preparedStatement.setString(1, fac.getLocaton());
			preparedStatement.setString(2, fac.getName());
			preparedStatement.setString(3, fac.getShortCode());
			preparedStatement.setInt(4, fac.getFacId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteFaculty(Faculty fac){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("delete from faculties where id = ?");
			// Parameters start with 1
			preparedStatement.setInt(1, fac.getFacId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Get faculty by Id
	public Faculty getFacultyById(int fac_id){
		Faculty fac = new Faculty();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from faculties where id = ?");
					// Parameters start with 1
			preparedStatement.setInt(1, fac_id);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
			fac.setFacId(rs.getInt("id"));
			fac.setLocaton(rs.getString("location"));
			fac.setName(rs.getString("name"));
			fac.setShortCode(rs.getString("short_code"));
		}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return fac;
	}
	
	//Get all the faculties in the system
	public ArrayList<Faculty> getAllFaclties(){
		ArrayList<Faculty> fac = new ArrayList<Faculty>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from faculties");
			while (rs.next()) {
			Faculty f = new Faculty();
			f.setFacId(rs.getInt("id"));
			f.setLocaton(rs.getString("location"));
			f.setName(rs.getString("name"));
			f.setShortCode(rs.getString("short_code"));
			fac.add(f);
		}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return fac;
	}
	
	//Get HTML of all courses
	public String getAllFacltiesHTML(){
		String html = "";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from faculties");
			while (rs.next()) {
				html += "<option value='" + rs.getInt("id") + "'>" + rs.getString("name") + ""
						+ "</option>";
		}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return html;
	}

}
