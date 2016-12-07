<%@ page contentType="text/html; charset=GB2312" %>
<%@ page import="mypack.*" %>
<html><head><title>maillogout</title></head>
<body>

<%
User user=(User)session.getAttribute("user");
String name=null;
if(user!=null)name=user.getName();

session.invalidate(); 
%>
<%=name%>,再见！
<p>
<p>
<a href="<%=response.encodeURL("maillogin.jsp")%>">重新登录邮件系统</a>

</body></html>
