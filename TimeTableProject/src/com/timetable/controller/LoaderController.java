package com.timetable.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.timetable.dao.CourseDao;
import com.timetable.dao.DepartmentDao;
import com.timetable.dao.FacultyDao;
import com.timetable.dao.HallDao;
import com.timetable.dao.LecturerDao;
import com.timetable.model.AjaxReturnObject;


public class LoaderController extends HttpServlet implements javax.servlet.Servlet {

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
 
        //Get the type of load request that was send:
        //1 = courses, 2 = lecturers, 3 = Hall, 4 = Faculties, 5 = departments
        int loadId = Integer.parseInt(request.getParameter("loadId"));
        
        Gson gson = new Gson();
        JsonObject myObj = new JsonObject();
        
        AjaxReturnObject selectionList = new AjaxReturnObject();
        //Get a Dao object for the selected list option
        switch(loadId){
        case 1://Courses
        	 CourseDao cdao = new CourseDao();
        	 int depId = Integer.parseInt(request.getParameter("dep_id"));
             selectionList.setHtml(cdao.getHTMLAllCoursesForDepartment(depId));             
        	break;
        case 2://Lecturers
        	LecturerDao ldao = new LecturerDao();
        	int facId = Integer.parseInt(request.getParameter("fac_id"));
        	selectionList.setHtml(ldao.getHTMLLecturersFromFaculty(facId));
        	break;
        case 3://Halls
        	HallDao hdao = new HallDao();
        	selectionList.setHtml(hdao.getHTMLAllHalls());
        	break;
        case 4://Faculties
        	FacultyDao fdao = new FacultyDao();
        	selectionList.setHtml(fdao.getAllFacltiesHTML());
        	break;
        case 5:
        	//Departments
        	DepartmentDao ddao = new DepartmentDao();
        	int facId1 = Integer.parseInt(request.getParameter("fac_id"));
        	selectionList.setHtml(ddao.getAllDepartmentHTMLByFacId(facId1));
        	break;
        	default:
        		selectionList.setHtml("<option value='1'>Empty!</option>");
        		break;
        }
       
        
        JsonElement listObj = gson.toJsonTree(selectionList);
        if(selectionList.getHtml() == null){
            myObj.addProperty("success", false);
        }
        else {
            myObj.addProperty("success", true);
        }
        myObj.add("selectionList", listObj);
        out.println(myObj.toString());
        out.println();
 
        out.close();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		doPost(req, res);
	}

}
