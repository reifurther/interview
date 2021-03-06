package com.cup.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloForm
 */
@WebServlet("/HelloForm")
public class HelloForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String title = "use GET method to read form data.";
		String docType = "<!DOCTYPE html>\n";
		
		out.println(docType +
				"<html>\n" +
				"<head><title>" + title + "</title></head>\n" +
				"<body bgcolor=\"#f0f0f0\">\n" +
			    "<h1 align=\"center\">" + title + "</h1>\n" +
			    "<ul>\n" +
			    "  <li><b>first name</b>"
			    + request.getParameter("first_name") + "\n" +
			    "  <li><b>last name</b>"
			    + request.getParameter("last_name") + "\n" +
			    "</ul>\n" +
			    "</body></html>");

		Cookie first_name = new Cookie("first_name", request.getParameter("first_name")); 
		Cookie last_name = new Cookie("last_name", request.getParameter("last_name"));
		
	
		first_name.setMaxAge(60); 
		last_name.setMaxAge(120); 

		response.addCookie( first_name );
		response.addCookie( last_name );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
