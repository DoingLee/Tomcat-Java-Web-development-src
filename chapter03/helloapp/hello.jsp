<%@ taglib uri="/mytaglib" prefix="mm" %>
<html>
<head>
  <title>helloapp</title>
</head>
<body>
  <b><mm:hello/> : <%= request.getAttribute("USER") %></b>
</body>
</html>
