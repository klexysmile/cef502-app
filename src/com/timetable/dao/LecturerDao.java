package com.timetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.timetable.model.Lecturer;
import com.timetable.util.DbUtil;

public class LecturerDao {
private Connection connection;
	
	public LecturerDao(){
		connection = DbUtil.getConnection();
	}
	
	public void addLecturer(Lecturer lec){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("insert into lecturers(name, office_address, contact, Faculties_id"
					+ ") values (?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, lec.getName());
			preparedStatement.setString(2, lec.getOfficeAddress());
			preparedStatement.setString(3, lec.getContact());
			preparedStatement.setInt(4, lec.getFacId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateLecturer(Lecturer lec){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("update lecturers set name = ?, office_address = ?, contact=?"
					+ ", Faculties_id = ? where id = ?");
			// Parameters start with 1
			preparedStatement.setString(1, lec.getName());
			preparedStatement.setString(2, lec.getOfficeAddress());
			preparedStatement.setString(3, lec.getContact());
			preparedStatement.setInt(4, lec.getFacId());
			preparedStatement.setInt(5, lec.getLecId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteHall(Lecturer lec){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("delete from lecturers where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, lec.getLecId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Get all Lecturers
	public ArrayList<Lecturer> getAllHalls(){
		ArrayList<Lecturer> lecturers = new ArrayList<Lecturer>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from halls");
			while (rs.next()) {
			Lecturer lec = new Lecturer();
			lec.setLecId(rs.getInt("id"));
			lec.setOfficeAddress(rs.getString("office_address"));
			lec.setName(rs.getString("name"));
			lec.setContact(rs.getString("contact"));
			lec.setFacId(rs.getInt("Faculties_id"));
			lecturers.add(lec);
		}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return lecturers;
		
	}
	
	//Get the selection list for all lecturers
			public String getHTMLAllLecturers(){
				String html = "";
				try {
					Statement statement = connection.createStatement();
					ResultSet rs = statement.executeQuery("select * from lecturers");
					while (rs.next()) {
					html += "<option value='" + rs.getInt("id") + "'>" + rs.getString("name") + ""
							+ "</option>";
				}
				} catch (SQLException e) {
					e.printStackTrace(); 
				}
				return html;
			}
			
	//??????????????????????????????????????????????????????????????????//	
	
	public Lecturer getLectererById(int id){
		Lecturer lecturer = new Lecturer();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from lecturers where id = ?");
					// Parameters start with 1
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
			lecturer.setLecId(rs.getInt("id"));
			lecturer.setName(rs.getString("name"));
			lecturer.setOfficeAddress(rs.getString("office_address"));
			lecturer.setContact(rs.getString("contact"));
			lecturer.setFacId(rs.getInt("Faculties_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}		
	
		return lecturer;
	}
	
	//Get all the lecs from a particular faculty
	public String getHTMLLecturersFromFaculty(int fac_id){
		String html = "";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from lecturers where Faculties_id = ?");
					// Parameters start with 1
			preparedStatement.setInt(1, fac_id);
			ResultSet rs = preparedStatement.executeQuery();
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
