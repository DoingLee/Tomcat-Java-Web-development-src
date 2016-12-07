<%@ page contentType="text/html; charset=GB2312" %>
<%@ page import="mypack.MyData" %>

<% String action=request.getParameter("action");
if(action==null){ %>

<a href="sessionopt.jsp?action=add">加入属性</a> <br>
<a href="sessionopt.jsp?action=invalidate">结束会话</a> <br>

<%
}else if(action.equals("invalidate")){
  session.invalidate();
%>
<a href="sessionopt.jsp">开始新的会话</a> <br>
<%
}else if(action.equals("add")){
  session.setAttribute("data",new MyData(1));
%>

<a href="sessionopt.jsp?action=replace">替换属性</a> <br>
<a href="sessionopt.jsp?action=remove">删除属性</a> <br>
<a href="sessionopt.jsp?action=invalidate">结束会话</a> <br>

<%
}else if(action.equals("remove")){
  session.removeAttribute("data");
%>
<a href="sessionopt.jsp?action=add">加入属性</a> <br>
<a href="sessionopt.jsp?action=invalidate">结束会话</a> <br>

<%
}else if(action.equals("replace")){
  session.setAttribute("data",new MyData(1));

%>
<a href="sessionopt.jsp?action=remove">删除属性</a> <br>
<a href="sessionopt.jsp?action=invalidate">结束会话</a> <br>
<%
}
%>


