<%@ page contentType="text/html; charset=GB2312" %>
<html><head><title>mailcheck</title></head>
<body>



<%
String name=null;
name=request.getParameter("username");
if(name!=null)
  session.setAttribute("username",name);
else{
  name=(String)session.getAttribute("username");
  if(name==null){
    response.sendRedirect("maillogin.jsp");    
  }
}
%>

<a href="maillogin.jsp">登录</a>&nbsp;&nbsp;&nbsp;
<a href="maillogout.jsp">注销</a>&nbsp;&nbsp;&nbsp;
<p>当前用户为：<%=name%> </P>
<P>你的信箱中有100封邮件</P>

</body></html>
