<%@ include file="common.jsp" %>

<%
String username=mud.getURLName().getUsername();
mud.getStore().close(); //�Ͽ����ʼ�������������
session.invalidate(); //����HTTP�Ự
%>

<html>
<head><title>Logout</title></head>
<body>

<h3>Goodbye,<%=username%>!</h3><br>
<strong><a href="login.jsp">Login again</a></strong>

</body></html>