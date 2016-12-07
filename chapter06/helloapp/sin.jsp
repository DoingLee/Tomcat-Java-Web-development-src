sin.jsp is including content.jsp.
<% int var=1; 
   request.setAttribute("username","Tom");
%>
<%@ include file="content.jsp" %> 

<p>sin.jsp is doing something else.
