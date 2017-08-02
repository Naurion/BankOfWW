<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User page</title>
</head>
<body>
	<h2>Enter to your account:</h2>
	<form action="login.jsp" method="post">
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

</body>
</html>