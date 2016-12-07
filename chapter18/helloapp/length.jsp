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

数组长度：${fn:length(array)} <br>
集合长度：${fn:length(list)}  <br>
字符串长度：${fn:length("Tomcat")}  <br>

</body>
</html>
