<%@ page import="mypack.CounterBean" %>

<html>
<head><title>Counter</title></head>
<body>

<jsp:useBean id="myPageBean" scope="page" class="mypack.CounterBean" />

<%-- 把myPageBean的count属性的值加1 --%>
<jsp:setProperty name="myPageBean" property="count"
	value="<%=myPageBean.getCount()+1 %>" />

<%-- 打印myPageBean的count属性 --%>
Current count value is :<jsp:getProperty name="myPageBean" property="count" />

<%
String scopeNames[]={"No scope","page","request","session","application"};
//寻找myPageBean的范围
int scope=pageContext.getAttributesScope("myPageBean");
%>

<%--打印myPageBean的范围 --%>
<p>scope=<%=scopeNames[scope]%></p>

<%--把请求转发给pageCounter2.jsp --%>
<%-- <jsp:forward page="pageCounter2.jsp" /> --%>

</body>
</html>
