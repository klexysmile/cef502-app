package com.timetable.model;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.timetable.dao.TimeTableDao;

public class IndividualListTag extends SimpleTagSupport {
	private int slot = 1;
	private int day = 1;
	private int lec = 1;
	
	
	public void doTag() throws JspException, IOException{
		super.doTag();
		TimeTableDao ttdao = new TimeTableDao();
		String tempString = ttdao.getIndiviualListByLecId(slot, day, lec);
		if(tempString.equalsIgnoreCase(""))
			tempString = "-";
		getJspContext().getOut().write("");
		getJspContext().getOut().write(tempString);
		getJspContext().getOut().write("");
	}


	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}


	public int getDay() {
		return day;
	}


	public void setDay(int day) {
		this.day = day;
	}


	public int getLec() {
		return lec;
	}


	public void setLec(int fac) {
		this.lec = fac;
	}

	
	
}
