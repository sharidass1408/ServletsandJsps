<%@ page language="java" import="java.util.*;"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 3.2//EN">
<html>
<head>
<link rel="stylesheet" href="style.css">

<meta name="GENERATOR" content="PageBreeze Free HTML Editor (http://www.formbreeze.com/freehtmleditor.htm">
<title>Nerdery Intrative Labs</title>
 <script language="javascript">
 function init(){
	 var addcookie= ReadCookie('addcookie');
	// alert("onload");
	 if(addcookie == 'no'){
		 var addbt = document.getElementById('addbt');
		 addbt.style.visibility='hidden';		 
	 }
	 
	 var keyValuePairs = document.cookie.split(';');
	// alert("keyValuePairs.length"+document.cookie);
	 for(var i = 0; i < keyValuePairs.length; i++) {
	     var name = keyValuePairs[i].substring(0, keyValuePairs[i].indexOf('='));
	     var value = keyValuePairs[i].substring(keyValuePairs[i].indexOf('=')+1);
	   //  alert("name:"+name+" value:"+value)
	     if(name.contains("vote")){
	    	 var votebt = document.getElementById('vote'+value);
	   
			 votebt.style.visibility='hidden';		
	     }
	 }
	
 }
 
 function hidevote(id){
	
	 var vote = ReadCookie('vote'+id);
	 if(vote != ""){
	 var votebt = document.getElementById('vote'+id); 
	 votebt.style.visibility='hidden';
    }
 }
 
 function checkVote(id){
	 var voteid = ReadCookie(vote+id);
	// alert("checkVote:"+voteid);
	 if(voteid != ""){
		 var votebt = document.getElementById('vote'+id);
		 votebt.style.visibility='hidden';	
	 }
 }
 
 function SetCookie(cookieName,cookieValue,nDays) {
	 var today = new Date();
	 var expire = new Date();
	 if (nDays==null || nDays==0) nDays=1;
	 expire.setTime(today.getTime() + 3600000*24*nDays);
	 document.cookie = cookieName+"="+escape(cookieValue)
	                 + ";expires="+expire.toGMTString();
	}
 
 function ReadCookie(cookieName) {
	 var theCookie=" "+document.cookie;
	 var ind=theCookie.indexOf(" "+cookieName+"=");
	 if (ind==-1) ind=theCookie.indexOf(";"+cookieName+"=");
	 if (ind==-1 || cookieName=="") return "";
	 var ind1=theCookie.indexOf(";",ind+1);
	 if (ind1==-1) ind1=theCookie.length; 
	 return unescape(theCookie.substring(ind+cookieName.length+2,ind1));
	}

 
 function addGame(){
	   
	 var actionType = document.getElementById('actionType');
	 var newTitle = document.getElementById('addtitle');
	 actionType.value="Add";
	  if(newTitle.value == ""){
		  alert("Enter a value");
		  return;
	  }
	  SetCookie('addcookie','no',1) ;  
	  var addbt = document.getElementById('addbt');
	  addbt.style.visibility='hidden';
 }
 
 function voteGame(id){
	
	 var actionType = document.getElementById('actionType');
	 var gameid = document.getElementById('gameid');
	 actionType.value="Vote";
	 gameid.value=id;
	 SetCookie('vote'+id,id,1)  ; 
	 var votebt = document.getElementById('vote'+id);
	 votebt.style.visibility='hidden';
  }


  function ownGame(id){
	     var actionType = document.getElementById('actionType');
		 var gameid = document.getElementById('gameid');
		 actionType.value="Own";
		 gameid.value=id;
  }
</script>
</head>
<body bgcolor="#ffffff" background="bg_page.jpg" onload='init()'>
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
		     <td>Game ID</td><td>Game Title</td><td>No. of Votes</td><td>Elect</td>
			 <td>OwnerShip</td>
		 		 </tr>
		 		 
		 		 <%
	String bgcolor="";
	int count=0;
	List viewList = new ArrayList();
	String result="";
	Iterator  viewItr;
	
	if(request.getAttribute("gameList")!=null && request.getAttribute("gameList")!="")
	{
		List gameList =  (ArrayList)request.getAttribute("gameList");
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
			while(viewItr.hasNext())
			{
			  
				%>
				<td><%=viewItr.next()%></td>
				
				<%
			  	
			}
			count++;
			
			%>
			<td><input type="submit" name="vote<%=id%>" id="vote<%=id%>" value="Vote" style="background-color:#49743D;font-weight:bold;color:#ffffff;" onclick="voteGame(<%=id%>);" onmousemove="hidevote(<%=id%>);"></td>
				<td><input type="submit" name="own" id="own" style="background-color:#ff0000;font-weight:bold;;color:#ffffff;" value="OWN" onclick="ownGame(<%=id%>);"></td>
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
	result = (String)request.getAttribute("result");
	if(result == null) result="";
	%><td><%=result%></td>
		 		 
		 		 
		              </table></p>
		              <input type="hidden" name="actionType" id="actionType" value="votepage" />
		              <input type="hidden" name="gameid" id="gameid" />
		              <input name="addtitle" id="addtitle"><input type="submit" value="Add Title" id="addbt" onclick="addGame(this);" ></td></tr></table>   </h2></td></tr>
  <tr>
    <td bgcolor="#004000">&nbsp;</td></tr></table>
    </FORM></p>
    
   <iframe frameborder='0' width="100%" height="700px" onload="checkVote('2');"></iframe> 

</body>

</html>