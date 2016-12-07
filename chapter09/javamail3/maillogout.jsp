<%@ page contentType="text/html; charset=GB2312" %>
<html><head><title>maillogout</title></head>
<body>

<%
String name=(String)session.getAttribute("username");
session.invalidate(); 
%>
<%=name%>,再见！
<p>
<p>
<a href="<%=response.encodeURL("maillogin.jsp")%>">重新登录邮件系统</a>

</body></html>
