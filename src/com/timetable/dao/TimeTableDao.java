package com.timetable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.timetable.model.Course;
import com.timetable.model.Hall;
import com.timetable.model.Lecturer;
import com.timetable.model.TimeTable;
import com.timetable.util.DbUtil;


public class TimeTableDao {
	private Connection connection;
	
	public TimeTableDao(){
		connection = DbUtil.getConnection();
	}
	
	public boolean addTimeSlot(TimeTable timeSlot){
		boolean success = false;
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("insert into timetables(slot, Halls_id,"
					+ " Courses_id, Lecturers_id, day, Courses_Departments_id) values (?, ?, ?, ?, ?, ?)");
			// Parameters start with 1
			preparedStatement.setInt(1, timeSlot.getSlot());
			preparedStatement.setInt(2, timeSlot.getHallId());
			preparedStatement.setInt(3, timeSlot.getCourseId());
			preparedStatement.setInt(4, timeSlot.getLecturerId());
			preparedStatement.setInt(5, timeSlot.getDay());
			preparedStatement.setInt(6, timeSlot.getDepartment());
			preparedStatement.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return success;
	}
	
	public void deleteTimeSlot(TimeTable timeSlot){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("delete from timetables where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, timeSlot.getSlotId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateTimeSlot(TimeTable timeSlot){
		try {
			PreparedStatement preparedStatement = connection
			.prepareStatement("update timetables set slot = ?, Halls_id = ?,"
					+ " Courses_id = ?, Lecturers_id = ?, day = ?, Courses_Departments_id = ? where id = ?");
			// Parameters start with 1
			preparedStatement.setInt(1, timeSlot.getSlot());
			preparedStatement.setInt(2, timeSlot.getHallId());
			preparedStatement.setInt(3, timeSlot.getCourseId());
			preparedStatement.setInt(4, timeSlot.getLecturerId());
			preparedStatement.setInt(5, timeSlot.getDay());
			preparedStatement.setInt(6, timeSlot.getDepartment());
			preparedStatement.setInt(7,  timeSlot.getSlotId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<TimeTable> getAllTimeSlots(){
		ArrayList<TimeTable> tt = new ArrayList<TimeTable>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from timetables");
			while (rs.next()) {
			TimeTable t = new TimeTable();
			t.setCourseId(rs.getInt("Courses_id"));
			t.setHallId(rs.getInt("Halls_id"));
			t.setLecturerId(rs.getInt("Lecturers_id"));
			t.setSlotId(rs.getInt("id"));
			t.setSlot(rs.getInt("slot"));
			t.setDay(rs.getInt("day"));
			t.setDepartment(rs.getInt("Courses_Departments_id"));
			tt.add(t);
		}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return tt;
	}
	
	public TimeTable getTimeSlotById(int id){
		TimeTable t = new TimeTable();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from timetables where id = ?");
					// Parameters start with 1
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
				t.setCourseId(rs.getInt("Courses_id"));
				t.setHallId(rs.getInt("Halls_id"));
				t.setLecturerId(rs.getInt("Lecturers_id"));
				t.setSlotId(rs.getInt("id"));
				t.setSlot(rs.getInt("slot"));
				t.setDay(rs.getInt("day"));
				t.setDepartment(rs.getInt("Courses_Departments_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return t;
	}
	
	//Method to determine if a hall is free at a particular time and day
	
		public boolean hallIsFree(int hall, int day, int time){
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from timetables where (Halls_id = ? and slot = ?) and day = ?");
						// Parameters start with 1
				preparedStatement.setInt(1, hall);
				preparedStatement.setInt(2, time);
				preparedStatement.setInt(3, day);
				ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()) {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace(); 
			}	
			return true;
		}
		
	//Method to determine if a lecturer is free for a particular period of a day
		public boolean lecturerIsFree(int lec, int day, int time){
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from timetables where (Lecturers_id = ? and slot = ?) and day = ?");
						// Parameters start with 1
				preparedStatement.setInt(1, lec);
				preparedStatement.setInt(2, time);
				preparedStatement.setInt(3, day);
				ResultSet rs = preparedStatement.executeQuery();
				if (rs.next()) {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace(); 
			}	
			return true;
		}
		
	//Method to get the list of free faculty members for a particular time slot
	public String getFreeLecturersForSlot(int slot, int day, int faculty){
		String res = "";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT Lecturers.name from lecturers where "
							+ "Faculties_id = ? and Lecturers.id not in (Select Lecturers_id "
							+ "from timetables where slot = ? and day = ?)");
					// Parameters start with 1
			preparedStatement.setInt(1, faculty);
			preparedStatement.setInt(2, slot);
			preparedStatement.setInt(3, day);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				res += rs.getString("name");
				res += "<br/>";
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}	
		return res;
	}
	
	//Method to compute the individual list from time table
	public String getIndiviualListByLecId(int slot, int day, int lec){
		Lecturer lecturer = new Lecturer();
		Course course = new Course();
		Hall hall = new Hall();
		String res = "";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT Courses_id, Lecturers_id, "
							+ "Halls_id from timetables where "
							+ "(Lecturers_id = ? and slot = ?) and day = ? ");
					// Parameters start with 1
			preparedStatement.setInt(1, lec);
			preparedStatement.setInt(2, slot);
			preparedStatement.setInt(3, day);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				LecturerDao ldao = new LecturerDao();
				lecturer = ldao.getLectererById(lec);
				HallDao hdao = new HallDao();
				hall = hdao.getHallById(rs.getInt("Halls_id"));
				CourseDao cdao = new CourseDao();
				course = cdao.getAllCoursesById(rs.getInt("Courses_id"));				
				//res += lecturer.getName();
				res += "<div align='center'>";
				res += "<strong>" + course.getCode()+ "</strong>";
				res += "<br/>";
				res += hall.getName();
				res += "<br/></div>";
				
			}else {
				res += "-";
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}	
		return res;
	}
	
	//Method used by blocked list tags
	public String getBlockedLecturersForSlot(int slot, int day, int faculty){
		String res = "";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT Lecturers.name, Lecturers.id from lecturers where "
							+ "Faculties_id = ? and Lecturers.id in (Select Lecturers_id "
							+ "from timetables where slot = ? and day = ?)");
					// Parameters start with 1
			preparedStatement.setInt(1, faculty);
			preparedStatement.setInt(2, slot);
			preparedStatement.setInt(3, day);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int lec_id = rs.getInt("id");
				PreparedStatement preparedStatement1 = connection
						.prepareStatement("SELECT Courses.name, Courses.code, Courses.id from courses where "
								+ "Courses.id in (Select Courses_id "
								+ "from timetables where (slot = ? and day = ?) and Lecturers_id = ?)");
				preparedStatement1.setInt(1, slot);
				preparedStatement1.setInt(2, day);
				preparedStatement1.setInt(3, lec_id);
				ResultSet rs1 = preparedStatement1.executeQuery();
				res += rs.getString("name");
				if(rs1.next()){
					res += " - " + rs1.getString("code");					
				}	
				res += "<br/>";
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}	
		return res;
	}
	
}
