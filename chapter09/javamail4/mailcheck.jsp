<%@ page contentType="text/html; charset=GB2312" %>
<%@ page import="mypack.*,java.util.* " %>
<html><head><title>mailcheck</title></head>
<body>


<%
String name=null;
User user=null;
name=request.getParameter("username");
if(name!=null)
  session.setAttribute("user",new User(name));
else{
  user=(User)session.getAttribute("user");
  if(user==null){
    response.sendRedirect(response.encodeRedirectURL("maillogin.jsp"));    
  }
}
%>

<a href="<%=response.encodeURL("maillogin.jsp")%>">��¼</a>&nbsp;&nbsp;&nbsp;
<a href="<%=response.encodeURL("maillogout.jsp")%>">ע��</a>&nbsp;&nbsp;&nbsp;
<p>��ǰ�û�Ϊ��<%=name%> </P>
<P>�����������100���ʼ�</P>


<%
OnlineUsers onlineUsers=OnlineUsers.getInstance();
List<String> users=onlineUsers.getUsers();
%>
<hr>
��ǰ��������Ϊ��<%=onlineUsers.getCount() %> <br>
<% for(int i=0;i<users.size();i++){%>
<%=users.get(i)%> &nbsp;&nbsp;

<%}%>

</body></html>
