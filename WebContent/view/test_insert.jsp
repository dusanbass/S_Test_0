<%@page import="daoPak.DAO"%>
<%@page import="devPak.Car"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>test insert</title>
</head>
<body>
<form action="../ServletInsertCar" method="post">
	<label>Make:<input type="text" name="make"></label><br>
	<label>Model:<input type="text" name="type"></label><br>
	<input type="submit" name="sub" value="sub"><br>
</form>
${msg}
<br><br>
<%
ArrayList<Car> alCar = null;
DAO dao = new DAO();
alCar = dao.getAllCars();
if( alCar != null )
for(Car c : alCar){
	out.println(c + "<a href=../ServletSetupCar?id="+ c.getId() +" >Setup Car</a>" + ", "
			+ "<a href=test_setup_img.jsp?id="+ c.getId() +" >Set Images</a>" + "<br>"
			);
}
	
%>

</body>
</html>