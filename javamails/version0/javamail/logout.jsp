<%@ include file="common.jsp" %>

<%
String username=mud.getURLName().getUsername();
mud.getStore().close(); //断开与邮件服务器的连接
session.invalidate(); //结束HTTP会话
%>

<html>
<head><title>Logout</title></head>
<body>

<h3>Goodbye,<%=username%>!</h3><br>
<strong><a href="login.jsp">Login again</a></strong>

</body></html>