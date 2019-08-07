package com.sterlite.employee;

import java.beans.DesignMode;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signUpUser
 */
@WebServlet("/signUpUser")
public class signUpUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InMemoryDAO putUser = new InMemoryDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signUpUser() {
        super();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String emailId = request.getParameter("email");
	
		BigInteger mobileNumber = BigInteger.valueOf(Long.parseLong(request.getParameter("mobile")));
		String address = request.getParameter("address");
		String designation = request.getParameter("designation");
		User user = new User(username,password,emailId,mobileNumber,address,designation);
		
		if(!(putUser.userExist(username))) {
			putUser.insertUser(username, user);
			PrintWriter browser = response.getWriter();
			browser.print("User registered succesfully");
		}
		else {
			PrintWriter browser = response.getWriter();
			browser.print("<p align='center' style='font-weight:bold; color:#fc2403'>User already exist!!</p>");
		}	
		
		RequestDispatcher rd = request.getRequestDispatcher("/signUp.html");
		rd.include(request, response);
	}
	
	

}
