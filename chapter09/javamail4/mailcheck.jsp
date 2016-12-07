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

<a href="<%=response.encodeURL("maillogin.jsp")%>">登录</a>&nbsp;&nbsp;&nbsp;
<a href="<%=response.encodeURL("maillogout.jsp")%>">注销</a>&nbsp;&nbsp;&nbsp;
<p>当前用户为：<%=name%> </P>
<P>你的信箱中有100封邮件</P>


<%
OnlineUsers onlineUsers=OnlineUsers.getInstance();
List<String> users=onlineUsers.getUsers();
%>
<hr>
当前在线人数为：<%=onlineUsers.getCount() %> <br>
<% for(int i=0;i<users.size();i++){%>
<%=users.get(i)%> &nbsp;&nbsp;

<%}%>

</body></html>
