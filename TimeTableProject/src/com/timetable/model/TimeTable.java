package com.timetable.model;

public class TimeTable {
	private int slotId;
	private int slot;
	private int hallId;
	private int courseId;
	private int lecturerId;
	private int day;
	private int department;
	
	public TimeTable(){
		
	}
	public String toString(){
		String s = "Slot : " + getSlot();
		s += "\nHall : " + getHallId();
		s += "\nCourse : " + getCourseId();
		s += "\nLecturer : " + getLecturerId();
		s += "\nDay : " + getDay();
		s += "\nDepartment : " + getDepartment();
		
		return s;
	}
	//Getters and setters
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public int getHallId() {
		return hallId;
	}
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getLecturerId() {
		return lecturerId;
	}
	public void setLecturerId(int lecturerId) {
		this.lecturerId = lecturerId;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
	}
	public int getDepartment() {
		return department;
	}
	public void setDepartment(int department) {
		this.department = department;
	}
	
}
