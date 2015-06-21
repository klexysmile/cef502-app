package com.timetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.timetable.model.Department;
import com.timetable.util.DbUtil;

public class DepartmentDao {
	private Connection connection;
	
	public DepartmentDao(){
		connection = DbUtil.getConnection();
	}
	
	public void addDepartment(Department dep){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("insert into departments(name, Faculties_id"
					+ ") values (?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, dep.getName());
			preparedStatement.setInt(2, dep.getFacId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateDepartment(Department dep){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("update departments set name = ?, Faculties_id = ?"
					+ " where id = ?");
			// Parameters start with 1
			preparedStatement.setString(1, dep.getName());
			preparedStatement.setInt(2, dep.getFacId());
			preparedStatement.setInt(3, dep.getDepId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteDepartment(Department dep){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("delete from departments where id = ?");
			// Parameters start with 1
			preparedStatement.setInt(1, dep.getDepId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Get department by Id
	public Department getDepartmentById(int dep_id){
		Department dep = new Department();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from departments where id = ?");
					// Parameters start with 1
			preparedStatement.setInt(1, dep_id);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
			dep.setFacId(rs.getInt("Faculties_id"));
			dep.setDepId(rs.getInt("id"));
			dep.setName(rs.getString("name"));
		}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return dep;
	}
	
	//Get all the departments from a faculty in the system
	public ArrayList<Department> getAllDepartmentsByFacId(int fac_id){
		ArrayList<Department> dep = new ArrayList<Department>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from departments where Faculties_id = ?");
					// Parameters start with 1
			preparedStatement.setInt(1, fac_id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
			Department f = new Department();
			f.setFacId(rs.getInt("Faculties_id"));
			f.setDepId(rs.getInt("id"));
			f.setName(rs.getString("name"));
			dep.add(f);
		}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return dep;
	}
	
	//Get HTML of all departments from a given faculty
	public String getAllDepartmentHTMLByFacId(int fac_id){
		String html = "";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from departments where Faculties_id = ?");
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
