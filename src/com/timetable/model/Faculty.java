package com.timetable.model;

public class Faculty {
	private int facId;
	private String name;
	private String shortCode;
	private String locaton;
	
	public Faculty(){
		
	}

	public int getFacId() {
		return facId;
	}

	public void setFacId(int facId) {
		this.facId = facId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortCode() {
		return shortCode;
	}

	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}

	public String getLocaton() {
		return locaton;
	}

	public void setLocaton(String locaton) {
		this.locaton = locaton;
	}
	
}
