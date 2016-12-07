<%@ page import="java.io.*" %>
<!--设置中文输出-->
<%@ page contentType="text/html; charset=GB2312" %>
<%@ page isErrorPage="true" %>
<html><head><title>Error Page</title></head>
<body>
	<p>
		服务器端发生错误:<%= exception.getMessage() %>
	</p>
	<p>
		错误原因为：<% exception.printStackTrace(new PrintWriter(out));%>
	</p>
</body></html>
