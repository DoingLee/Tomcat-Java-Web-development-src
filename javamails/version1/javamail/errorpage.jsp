<%@ page import="java.io.*" %>
<html><head><title>Error Page</title></head>
<body>
<%@ page isErrorPage="true" %>

<p>
  <font color="red" size="4">
    <b>Error Information:</b><%= exception.getMessage() %>
  </font>
</p>

</body></html>
