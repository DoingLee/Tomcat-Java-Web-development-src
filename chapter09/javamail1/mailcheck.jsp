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

<a href="maillogin.jsp">��¼</a>&nbsp;&nbsp;&nbsp;
<a href="maillogout.jsp">ע��</a>&nbsp;&nbsp;&nbsp;
<p>��ǰ�û�Ϊ��<%=name%> </P>
<P>�����������100���ʼ�</P>

</body></html>
