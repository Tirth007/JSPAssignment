<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
HttpServletResponse httpResponse = (HttpServletResponse) response;
httpResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
httpResponse.setHeader("Pragma", "no-cache"); 
httpResponse.setDateHeader("Expires", 0); 
%>
<%@ page import = "java.io.*,java.util.*" %>
<%@ page import = "com.sterlite.employee.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sterlite - Employees</title>
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/popper.min.js"></script>
<style>
	body{
		padding-top: 15px;
	}
</style>
</head>
<body>
<% 
	if(session.getAttribute("loggedIn") != null) {
		boolean res = (boolean) session.getAttribute("loggedIn");
		if(res){
			InMemoryDAO user = new InMemoryDAO();
			HashMap<String,User> users = user.getUsers(); 
%>
<div class="container">
	<div class="row">
		<div class="col-md-12" align="right">
			<form action="logout" method="get">
				<button type="submit" class="btn btn-danger">Logout</button>
			</form>
		</div>
	</div>
	<div class="table-responsive table-hover" style="overflow-x:auto; margin-top: 15px;">
		<table class="table">
			<thead class="text-primary">
				<th> User Name</th>
				<th> Email</th>
				<th> Mobile number</th>
				<th> Address</th>
				<th> Designation</th>
				<th> Actions</th>
			</thead>
			<tbody>
			<% for (Map.Entry<String,User> entry : users.entrySet()) { %>
				<tr>
					<td><% out.print(entry.getKey()); %></td>
					<td><% out.print(entry.getValue().getEmailId()); %></td>
					<td><% out.print(entry.getValue().getMobileNumber()); %></td>
					<td><% out.print(entry.getValue().getAddress()); %></td>
					<td><% out.print(entry.getValue().getDesignation()); %></td>
					<td>
						<a href="editProfile.jsp?user=<% out.print(entry.getKey()); %>" class="badge badge-warning"> Edit</a>
						<a href="deleteUser?user=<% out.print(entry.getKey()); %>" class="badge badge-danger"> Delete </a>
					</td>
				</tr>
			<% } %>
			</tbody>
		</table>
	</div>
</div>	
<% 		} else{
			out.print("<p class='alert alert-danger'>Login first!!</p>");
			out.print("<a href='EmployeeHome.html' class='badge badge-primary'> Login Here </a>");	
		}
	} 
	else { 
		out.print("<p class='alert alert-danger'>This is new session..login first to get the data</p>");
		out.print("<a href='EmployeeHome.html' class='badge badge-primary'> Login Here </a>");
	} 
%>
</body>
</html>
