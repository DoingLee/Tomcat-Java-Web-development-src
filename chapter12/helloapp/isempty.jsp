<%@ page import="java.util.HashMap" %>

(1)${empty pageScope.container} &nbsp; <!-- 打印true -->

<% 
HashMap container=new HashMap();
//定义集合类型的命名变量container
pageContext.setAttribute("container",container,PageContext.PAGE_SCOPE); 
%>

(2)${empty pageScope.container} &nbsp;  <!-- 打印true -->

<% container.put("name","Tom");%>

(3)${empty pageScope.container} &nbsp;  <!-- 打印false -->
(4)${empty param.username} &nbsp;  <!-- 打印true -->
(5)${!empty param.username} &nbsp;  <!-- 打印false -->
