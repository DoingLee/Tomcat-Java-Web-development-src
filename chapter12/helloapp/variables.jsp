<%@ page import="mypack.CounterBean" %>

<html>
<head><title>named varivable</title></head><body>

<jsp:useBean id="myPageBean" scope="page" class="mypack.CounterBean" />

<%-- 把myPageBean的count属性的值加1 --%>
<jsp:setProperty name="myPageBean" property="count"
	value="${myPageBean.count+1}" />

<%-- 打印myPageBean的count属性 --%>
Current count value is :${myPageBean.count} <p>


<% 
application.setAttribute("driver","com.mysql.jdbc.Driver");
%>
Current driver is :${applicationScope.driver} <p>

</body>
</html>
