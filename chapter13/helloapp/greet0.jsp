<%@page contentType="text/html; charset=GB2312" %>
<%@taglib uri="/mytaglib" prefix="mm" %>

<html><head><title>greet</title></head>
<body>
<% int size=3; %>
<% int count=3; 
String username=request.getParameter("username");
StringBuffer buffer=new StringBuffer();

//׼�������е�����
for(int i=0;i<count;i++){
  buffer.append("<font size='"+(size++)+"'>"+"\r\n");
  buffer.append("Hi,"+username+"<br>"+"\r\n");
  buffer.append("</font>"+"\r\n");
}

System.out.println(buffer);

//����û���Ϊ��Monster�����ʹ�ӡ��Go away,Monster!����
//����ʹ�ӡbuffer�е����ݡ�
if(username!=null && username.equals("Monster")){
%>  
  Go away,Monster!

<%}else{%>

  <%=buffer %>

<%}%>

</body></html>
