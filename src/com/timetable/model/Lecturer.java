package com.timetable.model;

public class Lecturer {
	private int lecId;
	private String name;
	private String contact;
	private String officeAddress;
	private int facId;
	
	public Lecturer(){
		
	}
	public int getLecId() {
		return lecId;
	}
	public void setLecId(int lecId) {
		this.lecId = lecId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public int getFacId() {
		return facId;
	}
	public void setFacId(int facId) {
		this.facId = facId;
	}
}
