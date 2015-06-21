package com.timetable.model;

public class AjaxReturnObject {
	private String status;
	private String html;
	
	public AjaxReturnObject(){
		this.html = "<option value='1'>Course 1</option>";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}
}
