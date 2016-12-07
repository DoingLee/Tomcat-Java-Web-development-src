<%@page contentType="text/html; charset=GB2312" %>
<%@taglib uri="/mytaglib" prefix="mm" %>

<html><head><title>greet</title></head>
<body>
<% int size=3; %>
<% int count=3; 
String username=request.getParameter("username");
StringBuffer buffer=new StringBuffer();

//准备缓存中的数据
for(int i=0;i<count;i++){
  buffer.append("<font size='"+(size++)+"'>"+"\r\n");
  buffer.append("Hi,"+username+"<br>"+"\r\n");
  buffer.append("</font>"+"\r\n");
}

System.out.println(buffer);

//如果用户名为“Monster”，就打印“Go away,Monster!”，
//否则就打印buffer中的数据。
if(username!=null && username.equals("Monster")){
%>  
  Go away,Monster!

<%}else{%>

  <%=buffer %>

<%}%>

</body></html>
