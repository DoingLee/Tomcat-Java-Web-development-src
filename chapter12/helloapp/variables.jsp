<%@ page import="mypack.CounterBean" %>

<html>
<head><title>named varivable</title></head><body>

<jsp:useBean id="myPageBean" scope="page" class="mypack.CounterBean" />

<%-- ��myPageBean��count���Ե�ֵ��1 --%>
<jsp:setProperty name="myPageBean" property="count"
	value="${myPageBean.count+1}" />

<%-- ��ӡmyPageBean��count���� --%>
Current count value is :${myPageBean.count} <p>


<% 
application.setAttribute("driver","com.mysql.jdbc.Driver");
%>
Current driver is :${applicationScope.driver} <p>

</body>
</html>
