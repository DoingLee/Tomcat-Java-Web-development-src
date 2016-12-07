<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${param.locale}" scope="session" />
<fmt:setBundle basename="messages"/>

<html>

<head>
  <title><fmt:message key="login.title" /></title>
</head>
<body >

<form name="loginForm" method="post" action="hello.jsp">
<table>
<tr><td><div align="right"><fmt:message key="login.user" />:</div></td>
<td><input type="text" name="username"></td></tr>
<tr><td><div align="right"><fmt:message key="login.password" />:</div></td>
<td><input type="password" name="password"></td></tr>

<tr>
<td></td>
<td>
<input type="Submit" name="Submit" value=<fmt:message key="login.submit" />
</td></tr>

</table>
</form>
</body>
</html>
