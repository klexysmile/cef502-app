package com.timetable.business;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timetable.dao.FacultyDao;

@WebServlet("/FreeListServlet")
public class FreeListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException {
		
		//result.setContentType( "text/html" );
		ServletContext sc = this.getServletContext();
		int facultyId =  Integer.parseInt(request.getParameter("fac"));
		request.setAttribute("fac_id", request.getParameter("fac"));
		FacultyDao fdao = new FacultyDao();
		request.setAttribute("facultyName", fdao.getFacultyById(facultyId).getName());
		RequestDispatcher rd = sc.getRequestDispatcher("/freelist.jsp?");
	    try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws java.io.IOException {
		res.setContentType( "text/html" );
		ServletContext sc = this.getServletContext();
		System.out.println("From servlet: " + req.getAttribute("fac"));
		req.setAttribute("fac", "2");
		RequestDispatcher rd = sc.getRequestDispatcher("/freelist.jsp?");
	    try {
			rd.forward(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //res.sendRedirect( "freelist.jsp?fac_id=" + fac);
	}

}
