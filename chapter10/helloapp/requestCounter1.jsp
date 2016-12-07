<%@ page import="mypack.CounterBean" %>

<html><head><title>Counter</title></head>
<body>

<jsp:useBean id="myRequestBean" scope="request" class="mypack.CounterBean" />

<jsp:setProperty name="myRequestBean" property="count"
	value="<%=myRequestBean.getCount()+1 %>" />

Current count value is :<jsp:getProperty name="myRequestBean" property="count" />

<%
String scopeNames[]={"No scope","page","request","session","application"};
int scope=pageContext.getAttributesScope("myRequestBean");
%>

<p>scope=<%=scopeNames[scope]%></p>

<%-- <jsp:forward page="requestCounter2.jsp" /> --%>

</body>
</html>