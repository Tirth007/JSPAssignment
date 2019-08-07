package com.sterlite.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class deleteUser
 */
@WebServlet("/deleteUser")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InMemoryDAO putUser = new InMemoryDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		if(request.getParameter("user") != null){ 
			HttpSession session = request.getSession(false);
			if(session != null) {
				boolean res = (boolean) session.getAttribute("loggedIn");
				if(res){
					String username = request.getParameter("user");
					putUser.removeUser(username);			
					RequestDispatcher rd = request.getRequestDispatcher("/welcomeUser.jsp");
					rd.forward(request, response);
				} else{
					out.print("<p class='alert alert-danger'>Login first!!</p>");
					out.print("<a href='EmployeeHome.html' class='badge badge-primary'> Login Here </a>");	
				}
			} else { 
				out.print("<p class='alert alert-danger'>This is new session..login first to get the data</p>");
				out.print("<a href='EmployeeHome.html' class='badge badge-primary'> Login Here </a>");
			} 
		} else {
			out.print("<p class='alert alert-danger'>Login first!!</p>");
			out.print("<a href='EmployeeHome.html' class='badge badge-primary'> Unauthenticated access!! </a>");	
		}
	}
}
