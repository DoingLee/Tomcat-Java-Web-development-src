<%@page contentType="text/html; charset=GB2312" %>
<%@taglib uri="/mytaglib" prefix="mm" %>

<html><head><title>greet</title></head>
<body>
<% int size=3; %>
  
  <mm:greet count="3">
    <font size="<%=size++ %>">
      Hi,${param.username} <br>
    </font>
  </mm:greet>  

</body></html>
