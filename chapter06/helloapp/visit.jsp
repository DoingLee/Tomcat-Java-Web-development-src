<%@ page contentType="text/html; charset=GB2312" %>
<%@ page import="java.io.*" %>
<html><head><title>visit.jsp</title></head><body>

<%!
  File tempDir=null; //ʵ������
  
  public void jspInit(){
    ServletContext application=getServletConfig().getServletContext();
    tempDir=(File)application.getAttribute("javax.servlet.context.tempdir");
  }
%>

����Ŀ¼Ϊ��<%=tempDir.getPath() %>

</body></html>
