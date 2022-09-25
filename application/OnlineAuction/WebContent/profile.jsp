<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Profile</title>
 <style><%@include file="../resources/css/style.css"%></style>
	<style><%@include file="../resources/css/accounts/profile.css"%></style>
	<style>
table, th, td {
  border: 1px solid;
  padding: 15px;
}
table{
	width: 75%
}
tr:nth-child(even) {background-color: #f2f2f2;}

.center {
  
  margin-left: auto;
  margin-right: auto;
  ;
}


</style>
</head>
<body>
<%@ include file="../common/navbar.jsp" %>
	<%@page import="java.util.ArrayList"%>
	<%@page import="java.util.List"%>
	<%@page import="java.util.Date"%>
	<%@page import="com.upsidedown.model.User"%>
	
	
 	 
        <%
        	User sessionUser = (User) session.getAttribute("user");
        	if(sessionUser.getUserType() == 0){
        %>
        		<h2 style="font-family: Arial" align='center'><b>Hey There Buyer!</b></h2>
        <%
        	}else{
        %>
        		<h2 style="font-family: Arial" align='center'><b>Hey There Seller!</b></h2>
        <%
        	}
        	
        %>
        <!-- getCreationTime() for last logged in --> 
        
    
    <table class="center">
		<tr>
			<td>Name</td>
			<td><%= sessionUser.getName() %></td>
		</tr>
		<tr>
			<td>Date Of Birth</td>
			<td><%= sessionUser.getDateOfBirth() %></td>
		</tr>
		<tr>
			<td>Email Id</td>
			<td><%= sessionUser.getEmail() %></td>
		</tr>
		<tr>
			<td>Phone Number</td>
			<td><%= sessionUser.getPhoneNumber() %></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><%= sessionUser.getAddress() %></td>
		</tr>
		<tr>
			<td>Wallet Amount</td>
			<td><%= sessionUser.getWalletAmt() %></td>
		</tr>
		<tr>
			<td>Last Logged In</td>
			<td><%= new Date(session.getCreationTime()) %></td>
		</tr>
	</table>
	
	<%@ include file="../common/footer.jsp" %>
	<script> <%@include file="../resources/js/index.js"%></script>

</body>
</html>