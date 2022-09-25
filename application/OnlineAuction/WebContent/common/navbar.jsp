<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign In</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">
</head>
<body>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.upsidedown.model.User"%>

 

<% 
	
		boolean isUserAuthenticated = session.getAttribute("isUserAuthenticated")!=null?true:false;
        isUserAuthenticated=true;
		int userType=1;
		if(session.getAttribute("userType")!=null){
			userType=(int)session.getAttribute("userType");
		}
		
		User u= (User)session.getAttribute("user");
		if(u!=null){
			session.setAttribute("name", u.getName());
		}
%>
 
<div id="bottomHeader">
	<div id="mySidebar" class="sidebar">
	
		<% if(isUserAuthenticated && userType == 0){ %> 
			<h3>Hello <%= u.getName() %></h3>
			 <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
			<a href="/OnlineAuction/index.jsp">Home</a>
			<a href="/OnlineAuction/profile">My Profile</a>
			<a href="/OnlineAuction/buyerHistory.jsp">Purchased Products</a>
			<a href="logout">Log Out</a>
			
		<%} 
		// usertype == 1 then seller 
		else if(isUserAuthenticated && userType == 1){ %>
		    <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
			<h3>Hello <%= u.getName() %></h3>
			<a href="/OnlineAuction/index.jsp">Home</a>
			<a href="/OnlineAuction/profile">My Profile</a>
			<a href="/OnlineAuction/addproduct.jsp">Add Product</a>
			<a href="/OnlineAuction/scheduleAuction.jsp">Schedule Auction</a>
			<a href="logout">Log Out</a>
		<%} %>
</div>

	<%
		if (isUserAuthenticated) {
	%>
	<div id="main">
	<img src="./resources/img/logo.jpg" style="width:50px;height: 50px;margin-left:16px">
		<button class="openbtn" onclick="openNav()">&#9776;</button>
		
	</div>
	<%
		} else {
	%>
	<div id="main">
	<img src="./resources/img/logo.jpg" style="width:50px;height: 50px;margin-left:16px">
	<div style="float:right">
	<a href="/login" class="navbar-button">Login</a>
	<a href="/register" class="navbar-button">Sign Up</a>
	</div>
	</div>
	<%
		}
	%>


</div>

</body>