<%@ page contentType="text/html; charset=GB2312" %>
<%@ page import="mypack.MyData" %>

<% String action=request.getParameter("action");
if(action==null){ %>

<a href="sessionopt.jsp?action=add">��������</a> <br>
<a href="sessionopt.jsp?action=invalidate">�����Ự</a> <br>

<%
}else if(action.equals("invalidate")){
  session.invalidate();
%>
<a href="sessionopt.jsp">��ʼ�µĻỰ</a> <br>
<%
}else if(action.equals("add")){
  session.setAttribute("data",new MyData(1));
%>

<a href="sessionopt.jsp?action=replace">�滻����</a> <br>
<a href="sessionopt.jsp?action=remove">ɾ������</a> <br>
<a href="sessionopt.jsp?action=invalidate">�����Ự</a> <br>

<%
}else if(action.equals("remove")){
  session.removeAttribute("data");
%>
<a href="sessionopt.jsp?action=add">��������</a> <br>
<a href="sessionopt.jsp?action=invalidate">�����Ự</a> <br>

<%
}else if(action.equals("replace")){
  session.setAttribute("data",new MyData(1));

%>
<a href="sessionopt.jsp?action=remove">ɾ������</a> <br>
<a href="sessionopt.jsp?action=invalidate">�����Ự</a> <br>
<%
}
%>


