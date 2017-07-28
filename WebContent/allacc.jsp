<%@page import="java.sql.ResultSet"%>
<%@page import="com.nbox.bank.DBConnector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	DBConnector con = DBConnector.getInstance();
	con.setQuery("SELECT * FROM minibank.accounts;");
	ResultSet res = con.getRs();
%>

<table border="1">
<caption>List of Accounts</caption>
<tr>
 <th>UserId</th><th>User name</th>
</tr>
<%while(res.next()){%>
	<tr>
	 <td><%=res.getString(1)%></td>
	 <td><%=res.getString(2)%></td>
	</tr>	
<%}%>
</table>

</body>
</html>