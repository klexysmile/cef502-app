package com.timetable.model;

public class Course {
	private int courseId;
	private String name;
	private String code;
	private int estimate;
	private int department;
	private int faculty;
	
	public Course(){
		
	}
	
	public String toString(){
		String s = "";
		s += "Course code: " + code + ", \n";
		s += "Course name: " + name + "";
		return s;
	}
	//Getters and Setters
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEstimate() {
		return estimate;
	}
	public void setEstimate(int estimate) {
		this.estimate = estimate;
	}
	public int getFaculty() {
		return faculty;
	}
	public void setFaculty(int faculty) {
		this.faculty = faculty;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	
	
}
