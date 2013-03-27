<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="com.nbna.model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration_Login_App</title>
</head>
<body>

<h3>Congrats you sucessfully logged in </h3>

<%
User user = (User) session.getAttribute("user");
//User user = (User) request.getAttribute("user");
%>

<h4> The following are your login details</h4>

    Name: <%= user.getName() %> <br>
 	UserId: <%= user.getUserid() %><br>	
 	Email: <%=user.getEmail() %><br>
 	
 	<br>Shipping Address:<br>
 	
 	Street: <%= user.getStreet() %><br>
 	City: <%= user.getCity() %><br>
 	State:	<%=user.getState() %><br>
 	ZipCode: <%=user.getZip() %><br>
 
</body>
</html>