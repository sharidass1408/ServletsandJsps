<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Url Mapping</title>
<style type="text/css">
		body{
			background-color: #d2b48c;
			margin-left: 15%;
			margin-right: 15%;
			border: 1px dotted gray;
			padding: 5px 5px 5px 5px;
			font-family: sans-serif;
		}
 
	</style>
</head>
<body>
<div align ="center">
 <h1>Welcome to Sri Ram's Website!!</h1>
 </div>
 <form action="Search" method="post">
 	<div align="center"> <br><br><br><br><br>
 	Path to PAC executable: <input type="text" name="pacexecutable" value=""/> <br>
 	Path to PAC file: 		<input type="text" name="pacfile" value=""/> <br>
 	Path to URL file:		<input type="text" name="pacurl" value=""/> <br>
 	<input type="submit" /> <br>
 	</div> 	
</form> 	 
  

</body>
</html>