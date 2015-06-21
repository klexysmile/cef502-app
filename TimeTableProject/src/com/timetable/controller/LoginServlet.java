package com.timetable.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.timetable.dao.LoginDao;
import com.timetable.model.SessionProps;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException { 

        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        Timestamp t = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass"); 
        
        HttpSession session = request.getSession(false);
        if(session!=null){
        	LoginDao.setSessionVariables(n, p, t);
        	session.setAttribute("identity", SessionProps.getSessionId());
        	session.setAttribute("role", SessionProps.getSessionRole());
        	session.setAttribute("name", SessionProps.getSessionName());
        	session.setAttribute("message", SessionProps.getSessionMessage());
        	session.setAttribute("time", SessionProps.getSessionTime());
        	session.setAttribute("create", SessionProps.getSessionCreate());
        }
        
        LoginDao.validate(n, p, t);
        if(SessionProps.isLoggedIn()){
//        	session.setAttribute("visit", SessionProps.getSessionVisits());	
        	System.out.println("I got to this point of the code!!");
        	RequestDispatcher rd=request.getRequestDispatcher("home.jsp");  
	        	rd.forward(request,response);  
        } else{  //
        	out.print("<p style=\"color:red\">Sorry username or password error</p>");  
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
           rd.include(request,response);  /*/
        	RequestDispatcher rd=request.getRequestDispatcher("logout.jsp");  
        	rd.forward(request,response);  /*  */
        }
        out.close();  
    }
}
