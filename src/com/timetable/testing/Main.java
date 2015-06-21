package com.timetable.testing;

import com.timetable.dao.CourseDao;
import com.timetable.model.Course;

public class Main {

	public static void main(String[] args) {
		Course c = new Course();
//		c.setCode("CEF504");
//		c.setName("Expert Systems and Neural Networks");
//		c.setDepartment(1);
//		c.setEstimate(20);
//		//c.setCourseId(2);
//		c.setFaculty(1);
		
		CourseDao d = new CourseDao();
		//c = d.getAllCoursesById(1);
		//System.out.println(c.toString());
		System.out.println(d.getHTMLAllCourses());
	}

}
