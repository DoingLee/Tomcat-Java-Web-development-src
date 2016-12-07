<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/mytaglib" prefix="mm" %>
<html>

 <%  String language=request.getParameter("language");
      	   if(language==null)language="English";
	   session.setAttribute("language",language);	
 %>  

<head>
  <title><mm:message key="login.title" /></title>
</head>
<body >
       <br>
       <form name="loginForm" method="post" action="hello.jsp">
        <table>
 	<tr><td><div align="right"><mm:message key="login.user" />:</div></td><td> <input type="text" name="username"></td></tr>
        <tr><td><div align="right"><mm:message key="login.password" />:</div></td><td><input type="password" name="password"></td></tr>
        <tr><td></td><td><input type="Submit" name="Submit" value=<mm:message key="login.submit" /> ></td></tr>
        </table>
	</form>
</body>
</html>
