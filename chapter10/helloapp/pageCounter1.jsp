<%@ page import="mypack.CounterBean" %>

<html>
<head><title>Counter</title></head>
<body>

<jsp:useBean id="myPageBean" scope="page" class="mypack.CounterBean" />

<%-- ��myPageBean��count���Ե�ֵ��1 --%>
<jsp:setProperty name="myPageBean" property="count"
	value="<%=myPageBean.getCount()+1 %>" />

<%-- ��ӡmyPageBean��count���� --%>
Current count value is :<jsp:getProperty name="myPageBean" property="count" />

<%
String scopeNames[]={"No scope","page","request","session","application"};
//Ѱ��myPageBean�ķ�Χ
int scope=pageContext.getAttributesScope("myPageBean");
%>

<%--��ӡmyPageBean�ķ�Χ --%>
<p>scope=<%=scopeNames[scope]%></p>

<%--������ת����pageCounter2.jsp --%>
<%-- <jsp:forward page="pageCounter2.jsp" /> --%>

</body>
</html>
