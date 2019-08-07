package com.sterlite.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InMemoryDAO users = new InMemoryDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		PrintWriter browser = response.getWriter();
		users.addUsers();
		HashMap<String, User> user = users.getUsers();
		
		if(user.containsKey(username)) {
			User userFound = user.get(username);
			if(userFound.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("loggedIn", true);
				RequestDispatcher rd = request.getRequestDispatcher("/welcomeUser.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher error = request.getRequestDispatcher("/EmployeeHome.html");
				error.include(request, response);
				browser.print("<p align='center' style='font-weight:bold; color:#fc2403'>Wrong credentials</p>");
			}
		}
		else {
			RequestDispatcher error = request.getRequestDispatcher("/EmployeeHome.html");
			error.include(request, response);
			browser.print("<p align='center' style='font-weight:bold; color:#fc2403'>User not found</p>");
		}
		
	}

}
