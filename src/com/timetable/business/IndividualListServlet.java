package com.timetable.business;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.timetable.dao.LecturerDao;

@WebServlet("/IndividualListServlet")
public class IndividualListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws java.io.IOException {
		
		//result.setContentType( "text/html" );
		ServletContext sc = this.getServletContext();
		System.out.println("From servlet: " + request.getParameter("faculty_id"));
		request.setAttribute("lec", request.getParameter("lecturer"));
		LecturerDao ldao = new LecturerDao();
		request.setAttribute("lecName", ldao.getLectererById(Integer.parseInt(request.getParameter("lecturer"))).getName());
		RequestDispatcher rd = sc.getRequestDispatcher("/individuallist.jsp?");
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
	}

}
