package com.timetable.model;

public class Department {
	private int depId;
	private String name;
	private int facId;
	
	public Department(){
		
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFacId() {
		return facId;
	}

	public void setFacId(int facId) {
		this.facId = facId;
	}

}
