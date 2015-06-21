package com.timetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.timetable.model.Course;
import com.timetable.util.DbUtil;

public class CourseDao {
	private Connection connection;

	public CourseDao(){
		connection = DbUtil.getConnection();
	}
	
	public void addCourse(Course course){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("insert into courses(code, name, estimate,"
					+ " Departments_id, Departments_Faculties_id) values (?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setString(1, course.getCode());
			preparedStatement.setString(2, course.getName());
			preparedStatement.setInt(3, course.getEstimate());
			preparedStatement.setInt(4, course.getDepartment());
			preparedStatement.setInt(5,  course.getFaculty());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateCourse(Course course){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("update courses set code=?, name=?, estimate=?,"
					+ " Departments_id=?, Departments_Faculties_id=? "
					+ "where id=?");
			// Parameters start with 1
			preparedStatement.setString(1, course.getCode());
			preparedStatement.setString(2, course.getName());
			preparedStatement.setInt(3, course.getEstimate());
			preparedStatement.setInt(4, course.getDepartment());
			preparedStatement.setInt(5,  course.getFaculty());
			preparedStatement.setInt(6, course.getCourseId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteCourse(Course course){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("delete from courses where id = ?");
			// Parameters start with 1
			preparedStatement.setInt(1, course.getCourseId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Course> getAllCourses(){
		ArrayList<Course> courses = new ArrayList<Course>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from courses");
			while (rs.next()) {
			Course course = new Course();
			course.setCourseId(rs.getInt("id"));
			course.setCode(rs.getString("code"));
			course.setDepartment(rs.getInt("Departments_id"));
			course.setEstimate(rs.getInt("estimate"));
			course.setName(rs.getString("name"));
			course.setFaculty(rs.getInt("Departments_Faculties_id"));
			courses.add(course);
		}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return courses;
	}
	
	//Get the selection list for all courses
		public String getHTMLAllCourses(){
			String html = "";
			try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from courses");
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
	//Get all the courses for a particular department
	public ArrayList<Course> getAllCoursesForDepartment(int dep_id){
		ArrayList<Course> courses = new ArrayList<Course>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from courses where Departments_id = ?");
					// Parameters start with 1
			preparedStatement.setInt(1, dep_id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
			Course course = new Course();
			course.setCourseId(rs.getInt("id"));
			course.setCode(rs.getString("code"));
			course.setDepartment(rs.getInt("Departments_id"));
			course.setEstimate(rs.getInt("estimate"));
			course.setName(rs.getString("name"));
			course.setFaculty(rs.getInt("Departments_Faculties_id"));
			courses.add(course);
		}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return courses;
	}
	
	//Get the selection list for courses for a particular department
	public String getHTMLAllCoursesForDepartment(int dep_id){
		String html = "";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from courses where Departments_id = ?");
					// Parameters start with 1
			preparedStatement.setInt(1, dep_id);
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
	////////////////////////////////////////////////////////////////////////
	
	public Course getAllCoursesById(int id){
		Course course = new Course();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from courses where id = ?");
					// Parameters start with 1
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
			
			course.setCourseId(rs.getInt("id"));
			course.setCode(rs.getString("code"));
			course.setDepartment(rs.getInt("Departments_id"));
			course.setEstimate(rs.getInt("estimate"));
			course.setName(rs.getString("name"));
			course.setFaculty(rs.getInt("Departments_Faculties_id"));
		}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return course;
	}
	
	
	
}
