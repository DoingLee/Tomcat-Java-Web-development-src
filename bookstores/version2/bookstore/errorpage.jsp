<%@ page import="java.io.*" %>
<!--�����������-->
<%@ page contentType="text/html; charset=GB2312" %>
<%@ page isErrorPage="true" %>
<html><head><title>Error Page</title></head>
<body>
	<p>
		�������˷�������:<%= exception.getMessage() %>
	</p>
	<p>
		����ԭ��Ϊ��<% exception.printStackTrace(new PrintWriter(out));%>
	</p>
</body></html>
