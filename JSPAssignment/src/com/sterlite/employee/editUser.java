package com.sterlite.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editUser
 */
@WebServlet("/editUser")
public class editUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InMemoryDAO putUser = new InMemoryDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editUser() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("user");
		String password = request.getParameter("password");
		String emailId = request.getParameter("email");
		BigInteger mobileNumber = BigInteger.valueOf(Long.parseLong(request.getParameter("mobile")));
		String address = request.getParameter("address");
		String designation = request.getParameter("designation");
		
		User user = new User(username,password,emailId,mobileNumber,address,designation);
		
		if(putUser.userExist(username)) {
			putUser.insertUser(username, user);
			PrintWriter browser = response.getWriter();
			browser.print("User updated succesfully");
		}
		else {
			PrintWriter browser = response.getWriter();
			browser.print("Some error occured");
		}	
		
		RequestDispatcher rd = request.getRequestDispatcher("/welcomeUser.jsp");
		rd.forward(request, response);
	}

}
