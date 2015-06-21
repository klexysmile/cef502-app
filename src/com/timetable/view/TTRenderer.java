package com.timetable.view;

public class TTRenderer {
	private String renderMarkup;

	public String getRenderMarkup() {
		return renderMarkup;
	}

	public void setRenderMarkup(String renderMarkup) {
		this.renderMarkup = renderMarkup;
	}
	
	public void append(String s){
		this.renderMarkup += s;
	}
}
