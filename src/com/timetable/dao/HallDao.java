package com.timetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.timetable.model.Hall;
import com.timetable.util.DbUtil;

public class HallDao {
	private Connection connection;
	
	public HallDao(){
		connection = DbUtil.getConnection();
	}
	
	public void addHall(Hall hall){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("insert into halls(name, location, capacity"
					+ ") values (?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, hall.getName());
			preparedStatement.setString(2, hall.getLocaton());
			preparedStatement.setInt(3, hall.getCapacity());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateHall(Hall hall){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("update halls set name=?, location=?, capacity=?"
					+ " where id=?");
			// Parameters start with 1
			preparedStatement.setString(1, hall.getName());
			preparedStatement.setString(2, hall.getLocaton());
			preparedStatement.setInt(3, hall.getCapacity());
			preparedStatement.setInt(4, hall.getHallId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteHall(Hall hall){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("delete from halls where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, hall.getHallId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Hall> getAllHalls(){
		ArrayList<Hall> halls = new ArrayList<Hall>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from halls");
			while (rs.next()) {
			Hall hall = new Hall();
			hall.setHallId(rs.getInt("id"));
			hall.setCapacity(rs.getInt("capacity"));
			hall.setLocaton(rs.getString("location"));
			hall.setName(rs.getString("name"));
			halls.add(hall);
		}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return halls;
	}
	
	//Get the selection list for all courses
		public String getHTMLAllHalls(){
			String html = "";
			try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from halls");
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
		
	//Get a particular hall from its id
		public Hall getHallById(int h){
			Hall hall = new Hall();
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from halls where id = ?");
						// Parameters start with 1
				preparedStatement.setInt(1, h);
				ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()) {
				hall.setHallId(rs.getInt("id"));
				hall.setCapacity(rs.getInt("capacity"));
				hall.setLocaton(rs.getString("location"));
				hall.setName(rs.getString("name"));
				}
			} catch (SQLException e) {
				e.printStackTrace(); 
			}		
		
			return hall;
		}
		
}
