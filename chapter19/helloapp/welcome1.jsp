<%@ taglib prefix="mm" tagdir="/WEB-INF/tags/" %>
<html>
<head>
<title>welcome</title>
</head>
<body>

<mm:welcome>
  <jsp:attribute name="username">
    ${param.username}
  </jsp:attribute> 
  <jsp:body>
    Welcome to my website.
  </jsp:body>
</mm:welcome>

</body></html>
