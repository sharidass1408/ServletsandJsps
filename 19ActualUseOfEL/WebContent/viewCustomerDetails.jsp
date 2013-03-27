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
     ${user.setName()}
	 ${user.setUserid() }
	 ${user.setEmail()} 	
 	 ${user.setAddress().setStreet()}
	 ${user.setAddress().setCity()}
	 ${user.setAddress().setState()}
     ${user.setAddress().setZip()}
</jsp:useBean>

<h4> The following are your login details</h4>
   
 	Name: ${user.getName()}
	UserId: ${user.getUserid() }
	Email: ${user.getEmail()}
 	 	 	
 	<br>Shipping Address:<br>
 	
 	Street: ${user.getAddress().getStreet()}
	city : ${user.getAddress().getCity()}
	state : ${user.getAddress().getState()}
 	zip :${user.getAddress().getZip()}

 
</body>
</html>