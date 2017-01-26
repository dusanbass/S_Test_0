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
		out.println(c + "<br>");
}catch(NumberFormatException e){
	e.printStackTrace();
}

%>
<br>
Please select add-ons:
<br>
<%
ArrayList<GearList> alGearList = dao.getGearListByCarId(c.getId());
out.println(alGearList);
if(alGearList != null && alGearList.size() > 0)
	out.print("checked");
ArrayList<Gear> alGear = dao.getAllGear();

// mehanizam za cekiranje chk-box-a
if(alGear != null && alGear.size() > 0){%>
	<form action="ServletSetupCar" method="post" >
	<input name="carId" value=<%=c.getId() %> type="hidden">
	<%
	for(Gear g : alGear){
		%>
		<label><%=g.getName() %>
			<input type="checkbox" name="gear" value=<%=g.getId() %> 
				<%
						if(alGearList != null && alGearList.size() > 0)
							for(GearList gl : alGearList)
								if(gl.getId_gear() == g.getId())
									%> checked="checked" <%
				%>>
		</label><br>
		 <%
	}%>
	<input type="submit" name="setup" value="Save Gear">
	</form> <%
} // kraj mehanizma
%>
</body>
</html>