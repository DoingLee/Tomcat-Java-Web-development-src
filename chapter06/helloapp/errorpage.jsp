<%@ page contentType="text/html; charset=GB2312" %>
<%@ page isErrorPage="true" %>
<%@ page import="java.io.PrintWriter" %>

<html><head><title>Error Page</title></head>
<body>

	<p>
		你输入的参数（num1=<%=request.getParameter("num1")%>,
                num2=<%=request.getParameter("num2")%>）有错误
	</p>
	<p>
		错误原因为：<% exception.printStackTrace(new PrintWriter(out));%>
	</p>
</body></html>
