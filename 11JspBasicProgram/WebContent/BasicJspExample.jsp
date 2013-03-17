<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import= "java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Testing Jsps</h3>
	<b>The time is : <%=new Date() %></b>
	<br>
	<%!public int add(int a, int b) {
		return a + b;
	}%>
	<!--  -->
	<%
		int i = 1;
		int j = 2;
		int k;
		k = i + j;

		out.println("Value of K is from scriplet " + k);
	%>

	The value of k is:
	<%=k%>
	The sum of 2+3 is:
	<%=2 + 3%>
	<%
		int l = add(5, 10);
	%>

	<br>The value of L is:
	<%=l%>
	
	  <%@ include file="/HelloClass.jsp" %>
</body>
</html>