<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.upsidedown.model.Category"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.upsidedown.model.ProductForAuction"%>
<%@page import="com.upsidedown.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style><%@include file="./resources/css/style.css"%></style>
<style><%@include file="./resources/css/home.css"%></style>
<style>
img {
  border: 1px solid #ddd;
  border-radius: 4px;
  padding: 5px;
  width: 400px;
}
</style>
</head>
<body>
<%@ include file="../common/navbar.jsp"%>
<h1 align='center'>No Products Currently Available for Auction</h1>
<div align='center'>
<img src="https://allinholidays.gr/wp-content/uploads/2018/10/%CE%B1%CF%81%CF%87%CE%B5%CE%AF%CE%BF-%CE%BB%CE%AE%CF%88%CE%B7%CF%82.png"/>
</div>
<%@ include file="../common/footer.jsp"%>
<script> <%@include file="../resources/js/index.js"%></script>
</body>
</html>