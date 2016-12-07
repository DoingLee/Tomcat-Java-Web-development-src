<html><head><title>form content</title></head>
<body>

<h3>Fill-out-form</h3>
<p>
<form action="form.jsp" method="GET">
     name=<input type="text" name="username" value="${param["username"]}">
          <input type="submit" value="Submit">
</form> 
<p>
The name is: ${param.username}
</body>
</html>
