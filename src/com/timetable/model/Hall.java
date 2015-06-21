package com.timetable.model;

public class Hall {
	private int hallId;
	private String name;
	private int capacity;
	private String locaton;
	
	public Hall(){
		
	}
	//Getters and setters
	public int getHallId() {
		return hallId;
	}
	public void setHallId(int hallId) {
		this.hallId = hallId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getLocaton() {
		return locaton;
	}
	public void setLocaton(String locaton) {
		this.locaton = locaton;
	}
}
