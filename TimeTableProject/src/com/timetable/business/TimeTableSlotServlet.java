package com.timetable.business;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.timetable.dao.TimeTableDao;
import com.timetable.model.AjaxReturnObject;
import com.timetable.model.TimeTable;

public class TimeTableSlotServlet extends HttpServlet implements javax.servlet.Servlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException {
		
		PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        response.setHeader("Cache-control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "-1");
 
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        response.setHeader("Access-Control-Max-Age", "86400");
 
        //Get the slot information that was sent from the front-end
        int depId = Integer.parseInt(request.getParameter("dep_id"));
        int courseId = Integer.parseInt(request.getParameter("course"));
        int day = Integer.parseInt(request.getParameter("day"));
        int hall = Integer.parseInt(request.getParameter("hall"));
        int lec = Integer.parseInt(request.getParameter("lec"));
        int slot = Integer.parseInt(request.getParameter("slot"));
        //Create TimeTable Object
        TimeTable tt = new TimeTable();
        tt.setCourseId(courseId);
        tt.setDepartment(depId);
        tt.setDay(day);
        tt.setHallId(hall);
        tt.setLecturerId(lec);
        tt.setSlot(slot);
        System.out.println(tt);
        //Create TimeTableDao to insert the data into the table
        TimeTableDao ttdao = new TimeTableDao();
        boolean success = false;
        if(ttdao.hallIsFree(hall, day, slot) && ttdao.lecturerIsFree(lec, day, slot))
        	success = ttdao.addTimeSlot(tt);
        
        Gson gson = new Gson();
        JsonObject myObj = new JsonObject();
        
        AjaxReturnObject successState = new AjaxReturnObject();
        //If the insert was successful, return a success message with the
        //Json response
        if(success)
        	successState.setHtml("<b style='color:green'>Time Slot Successfully added!<b>");
        else
        	successState.setHtml("<b style='color:red'>Error: Could not insert slot!<b>");        	       
        
        JsonElement listObj = gson.toJsonTree(successState);
        if(successState.getHtml() == null){
            myObj.addProperty("success", false);
        }
        else {
            myObj.addProperty("success", true);
        }
        myObj.add("successState", listObj);
        out.println(myObj.toString());
        out.println();
 
        out.close();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		doPost(req, res);
	}


}
