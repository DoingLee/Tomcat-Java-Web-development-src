<%@ page contentType="text/html; charset=GB2312" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head><title>length</title></head>
<body>

<%
int[] array={1,2,3,4};
ArrayList list=new ArrayList();
list.add("one");
list.add("two");
list.add("three");
%>

<c:set value="<%=array %>" var="array" />
<c:set value="<%=list %>" var="list" />

���鳤�ȣ�${fn:length(array)} <br>
���ϳ��ȣ�${fn:length(list)}  <br>
�ַ������ȣ�${fn:length("Tomcat")}  <br>

</body>
</html>
