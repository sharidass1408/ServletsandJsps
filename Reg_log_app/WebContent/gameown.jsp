<%@ page language="java" import="java.util.*;"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<html>
<head>
<link rel="stylesheet" href="style.css">

<meta name="GENERATOR" content="PageBreeze Free HTML Editor (http://www.formbreeze.com/freehtmleditor.htm">
<title>Nerdery Intrative Labs</title>

</head>
<body bgcolor="#ffffff" background="bg_page.jpg">
<p>
<FORM name="gameform" method="post" action="Nerdery">

<table cellspacing="1" cellpadding="3" width=auto align="center" bgcolor="#004000" 
border=0>
  
  <tr>
    <td>&nbsp;</td></tr>
  <tr>
    <td bgcolor="#ffffff">
      <p align="center">&nbsp;</p>
      <h2>
      <table cellspacing="0" cellpadding="9" width=auto align="center" border="0" style="WIDTH: auto; HEIGHT: 325px">
        
        <tr>
          <td>
            <h2>Xbox Game Voting Application</h2>
            <p>   Nerdery&nbsp;Corp</p>
            <p>
            <table >
               <tr style="background-color:#7BA88B;font-weight:bold;">
		     <td>Game ID</td><td>Game Title</td><td>No. of Votes</td>
		 		 </tr>
		 		 
		 		 <%
	String bgcolor="";
	int count=0;
	List viewList = new ArrayList();
	String result="";
	Iterator  viewItr;
	
	if(request.getAttribute("ownList")!=null && request.getAttribute("ownList")!="")
	{
		List gameList =  (ArrayList)request.getAttribute("ownList");
		Iterator itr = gameList.iterator();
		
		while(itr.hasNext())
		{
			
			if(count%2==0)
			{
			 bgcolor = "#C8E2D1";
			}
			else
			{
				
				bgcolor = "#EAF8EF";
			}
			
			viewList = (ArrayList)itr.next();
			int id = Integer.parseInt(viewList.get(0).toString());
			viewItr = viewList.iterator();
			%>
			<tr style="background-color:<%=bgcolor%>;">
			<%	
			for(int i=0;i<3;i++)
			{
			  
				%>
				<td><%=viewItr.next()%></td>
				
				<%
			  	
			}
			count++;
			
			%>
			</tr>
			<%
		}
	}
	if(count==0)
	{
		%>
		<tr><td colspan="9" align="center">&nbsp;</td></tr>
            <tr><td colspan="9" align="center">No Record Avaliable</td></tr>
		<%
	}
	
	%><td></td>
		 		 	 		 
		              </table></p>
		              <input type="hidden" name="actionType" id="actionType" value="votepage" />
		             <input type="submit" value="Back/Home" ></td></tr></table>   </h2></td></tr>
  <tr>
    <td bgcolor="#004000">&nbsp;</td></tr></table>
    </FORM></p>
</body>
</html>