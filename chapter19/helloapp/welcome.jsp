<%@ taglib prefix="mm" uri="/mytaglib" %>
<html>
<head>
<title>welcome</title>
</head>
<body>

<mm:welcome username="${param.username}">
  Welcome to my website.
</mm:welcome>

</body></html>
