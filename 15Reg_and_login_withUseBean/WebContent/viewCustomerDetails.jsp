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

<jsp:useBean id="user" class="com.nbna.model.User" scope ="session">
<!-- The values inside the use bean tag will be used if user object does not exist in session scope -->
	<jsp:setProperty property="name" name="user" value="Default user"/>
</jsp:useBean>

<h4> The following are your login details</h4>

    Name: <jsp:getProperty property="name" name="user" />
 	UserId: <jsp:getProperty property="userid" name="user"/>
 	Email: <jsp:getProperty property="email" name="user" />
 	
 	<br>Shipping Address:<br>
 	
 	Street: <jsp:getProperty property="street" name="user"/>
 	City: <jsp:getProperty property="city" name="user"/>
 	State:	<jsp:getProperty property="state" name="user"/>
 	ZipCode: <jsp:getProperty property="zip" name="user"/>
 
</body>
</html>