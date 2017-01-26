<%@page import="daoPak.DAO"%>
<%@page import="devPak.Gear"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert gear</title>
</head>
<body>
<form action="ServletInsertGear" method="post">
	<label for="name">Name:</label><input id="name" type="text" name="name"><br>
	<input type="submit" name="subGear" value="Submit gear">
</form>
${msg}
<br>
<%
DAO dao = new DAO();
ArrayList<Gear> alGear = dao.getAllGear();
if(alGear != null && alGear.size() > 0)
	for(Gear g : alGear)
		out.println(g + "<br>");
%>
</body>
</html>