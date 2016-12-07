<%@ page import="mypack.CounterBean" %>

<html><head><title>Counter</title></head>


<body>
<jsp:useBean id="mySessionBean" scope="session" class="mypack.CounterBean" />

<jsp:setProperty name="mySessionBean" property="count"
	value="<%=mySessionBean.getCount()+1 %>" />

Current count value is :<jsp:getProperty name="mySessionBean" property="count" />

<%
String scopeNames[]={"No scope","page","request","session","application"};
int scope=pageContext.getAttributesScope("mySessionBean");
%>

<p>scope=<%=scopeNames[scope]%></p>

</body>
</html>