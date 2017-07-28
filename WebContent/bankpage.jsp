<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bank page</title>
</head>
<body>
	<h2>Create new account:</h2>
	<form action="AddAccount" method="post">
	<table border = "0">
 
    <tr>
        <td><b>Username:</b></td>
        <td><input type = "text" name = "username" size = "50"/></td>
    </tr>
 
    <tr>
        <td><b>Password:</b></td>
        <td><input type = "text" name = "password" size = "50"/></td>
    </tr>
        <tr>
        <td colspan = "2"><input type = "submit" value = "Submit"/></td>
    </tr>
    </table>
	</form>
	
	<a href = "allacc.jsp">Show all Accounts</a>
	<a href = "findacc.html">Find account</a>
	<a href = "delacc.html">Delete account</a>
</body>
</html>