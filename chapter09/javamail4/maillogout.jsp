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
<%=name%>,�ټ���
<p>
<p>
<a href="<%=response.encodeURL("maillogin.jsp")%>">���µ�¼�ʼ�ϵͳ</a>

</body></html>
