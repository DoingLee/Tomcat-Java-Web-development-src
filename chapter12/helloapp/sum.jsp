<%@ page contentType="text/html; charset=GB2312" %>
<%@ taglib prefix="mm" uri="/mytaglib" %>
<html>
<head>
<title>functions</title>
</head>

<body>

<h3>Add Numbers</h3>
<p>
<form action="sum.jsp" method="get">
   user= <input type="text" name="user" 
        value="${mm:convert(param.user,'ISO-8859-1','GB2312')}">
   <br>
 
   x = <input type="text" name="x" value="${param.x}">
   <br>
   y = <input type="text" name="y" value="${param.y}">
   <input type="submit" value="Add Numbers">
</form>

<p>
the sum is: ${mm:add(param.x,param.y)}

</body>
</html>
