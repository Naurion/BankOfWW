<%@page import="com.nbox.bank.DBConnector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank of WildWest</title>
</head>
<body>
	<p>Hi!</p>
	<%DBConnector.getInstance();%>
	<a href = "bankpage.jsp">Bank login</a> <a href = "userpage.jsp">User login</a>
</body>
</html>