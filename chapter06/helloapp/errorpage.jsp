<%@ page contentType="text/html; charset=GB2312" %>
<%@ page isErrorPage="true" %>
<%@ page import="java.io.PrintWriter" %>

<html><head><title>Error Page</title></head>
<body>

	<p>
		������Ĳ�����num1=<%=request.getParameter("num1")%>,
                num2=<%=request.getParameter("num2")%>���д���
	</p>
	<p>
		����ԭ��Ϊ��<% exception.printStackTrace(new PrintWriter(out));%>
	</p>
</body></html>
