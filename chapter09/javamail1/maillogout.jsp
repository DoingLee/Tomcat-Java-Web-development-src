<%@ page contentType="text/html; charset=GB2312" %>
<html><head><title>maillogout</title></head>
<body>

<%
String name=(String)session.getAttribute("username");
session.invalidate(); 
%>

<%=name%>,�ټ���
<p>
<p>
<a href="maillogin.jsp">���µ�¼�ʼ�ϵͳ</a>&nbsp;&nbsp;&nbsp;

</body></html>
