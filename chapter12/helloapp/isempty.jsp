<%@ page import="java.util.HashMap" %>

(1)${empty pageScope.container} &nbsp; <!-- ��ӡtrue -->

<% 
HashMap container=new HashMap();
//���弯�����͵���������container
pageContext.setAttribute("container",container,PageContext.PAGE_SCOPE); 
%>

(2)${empty pageScope.container} &nbsp;  <!-- ��ӡtrue -->

<% container.put("name","Tom");%>

(3)${empty pageScope.container} &nbsp;  <!-- ��ӡfalse -->
(4)${empty param.username} &nbsp;  <!-- ��ӡtrue -->
(5)${!empty param.username} &nbsp;  <!-- ��ӡfalse -->
