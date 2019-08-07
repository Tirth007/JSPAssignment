<%@page import="com.sterlite.employee.InMemoryDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "com.sterlite.employee.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<script type="text/javascript" src="assets/js/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/popper.min.js"></script>
<style>
	body{
		padding-top: 15px;
	}
</style>
<title>Employee - Edit Profile</title>
</head>
<body>
	<% 
	
	if(request.getParameter("user") != null){ 
		if(session.getAttribute("loggedIn") != null) {
			boolean res = (boolean) session.getAttribute("loggedIn");
			if(res){
				String username = request.getParameter("user");
				InMemoryDAO users = new InMemoryDAO();
				User user = users.getUser(username);
					if(user != null){
	%>
	<div class="container">
		<div>
			<div class="row" style="height: 50px;">
				<div class="col-md-3">
					<img src="assets/images/STL.png" alt="Sterlite logo" width="24%" height="50%">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-11">
				<form action="editUser" method="post" class="form-group">
				<input type="hidden" name="user" id="user" value="<%out.print(user.getUsername()); %>" />
					<div class="row">
						<div class="col-md-3">
							<label for="username"> Username :</label>
						</div>
						<div class="col-md-9">
							<input disabled="disabled" type="text" name="username" id="username" placeholder="Your username" class="form-control" value="<%out.print(user.getUsername()); %>" required>
						</div>
					</div>
					<div class="row" style="margin-top: 15px;">
						<div class="col-md-3">
							<label for="email"> Email :</label>
						</div>
						<div class="col-md-9">
							<input type="email" name="email" id="email" placeholder="Your email" class="form-control" value="<%out.print(user.getEmailId()); %>" required>
						</div>
					</div>
					<div class="row" style="margin-top: 15px;">
						<div class="col-md-3">
							<label for="mobile"> Mobile No :</label>
						</div>
						<div class="col-md-9">
							<input type="number" name="mobile" id="mobile" placeholder="Your mobile" class="form-control" value="<%out.print(user.getMobileNumber()); %>" required>
						</div>
					</div>
					<div class="row" style="margin-top: 15px;">
						<div class="col-md-3">
							<label for="designation">  Designation :</label>
						</div>
						<div class="col-md-9">
							<input type="text" name="designation" id="designation" placeholder="Your Designation" class="form-control" value="<%out.print(user.getDesignation()); %>" required>
						</div>
					</div>
					<div class="row" style="margin-top: 15px;">
						<div class="col-md-3">
							<label for="address"> Address :</label>
						</div>
						<div class="col-md-9">
							<input type="textarea" name="address" id="address" placeholder="Your address" class="form-control" value="<%out.print(user.getAddress()); %>" required>
						</div>
					</div>
					<div class="row" align="center" style="margin-top: 30px;">
						<div class="col-md-12">
							<button type="submit" onclick="validate()" class="btn btn-danger" style="width: 50%">Update Profile</button>
						</div>
					</div>
				</form>		
			</div>			
		</div>
	</div>
	<%			
				}
			} else{
				out.print("<p class='alert alert-danger'>Login first!!</p>");
				out.print("<a href='EmployeeHome.html' class='badge badge-primary'> Login Here </a>");	
			}
		} 
		else { 
			out.print("<p class='alert alert-danger'>This is new session..login first to get the data</p>");
			out.print("<a href='EmployeeHome.html' class='badge badge-primary'> Login Here </a>");
		} 
	} else {
		out.print("<p class='alert alert-danger'>Login first!!</p>");
		out.print("<a href='EmployeeHome.html' class='badge badge-primary'> Unauthenticated access!! </a>");	
	}
	
	%>
</body>
</html>