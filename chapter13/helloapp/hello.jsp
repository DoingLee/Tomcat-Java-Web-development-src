<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="/mytaglib" prefix="mm" %>
<html>
<head>
  <title><mm:message key="hello.title" /></title>
</head>
<body>
  <b><mm:message key="hello.hi" />:${param.username}</b>
</body>
</html>
