<%@ page import="mypack.CounterBean" %>

<html><head><title>Counter</title></head>
<body>

<jsp:useBean id="myApplicationBean" scope="application" class="mypack.CounterBean" />

<jsp:setProperty name="myApplicationBean" property="count"
	value="<%=myApplicationBean.getCount()+1 %>" />

Current count value is :<jsp:getProperty name="myApplicationBean" property="count" />


<%
String scopeNames[]={"No scope","page","request","session","application"};
int scope=pageContext.getAttributesScope("myApplicationBean");
%>

<p>scope=<%=scopeNames[scope]%></p>

</body>
</html>
