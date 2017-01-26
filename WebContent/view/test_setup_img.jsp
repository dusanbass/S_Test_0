<%@page import="devPak.GearList"%>
<%@page import="devPak.Gear"%>
<%@page import="java.util.ArrayList"%>
<%@page import="daoPak.DAO"%>
<%@page import="devPak.Car"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Setup car tst</title>
</head>
<body>
Car has id of: ${msg}
<br>
<%
DAO dao = new DAO();
Car c = null;
try{
	int id = Integer.parseInt(request.getParameter("id")); 
	c = dao.getCarById(id);
	if( c != null)
		%> <img alt="" src=<%=c.getImg() %>><br> <%
		out.println(c + "<br>");
}catch(NumberFormatException e){
	e.printStackTrace();
}

%>
<br>
Please select images:
<br>
<%
ArrayList<GearList> alGearList = dao.getGearListByCarId(c.getId());
out.println(alGearList);
if(alGearList != null && alGearList.size() > 0)
	out.print("checked");
ArrayList<Gear> alGear = dao.getAllGear();
%>
<!-- MEHANIZAM ZA SLIKE -->
<form method="POST" enctype="multipart/form-data" action="ServletInsertImg">
  <label>Image to upload &nbsp<input type="file" name="upfile"><br/></label>
  <label>Description &nbsp<input type="text" name="alt"></label><br/>
  <br/>
  <input type="submit" value="Press"> to upload the file!
</form>
</body>
</html>