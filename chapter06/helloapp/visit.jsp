<%@ page contentType="text/html; charset=GB2312" %>
<%@ page import="java.io.*" %>
<html><head><title>visit.jsp</title></head><body>

<%!
  File tempDir=null; //实例变量
  
  public void jspInit(){
    ServletContext application=getServletConfig().getServletContext();
    tempDir=(File)application.getAttribute("javax.servlet.context.tempdir");
  }
%>

工作目录为：<%=tempDir.getPath() %>

</body></html>
