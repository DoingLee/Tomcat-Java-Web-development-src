<html><head><title>JavaMail</title></head>
<body >
<p><center>
<font size=+3><b>Welcome to Java Mail Web</b></font>
</center></p><hr>

<%
String loginfail=(String)request.getAttribute("loginfail");
if(loginfail!=null && loginfail.equals("true")){
%>

<center>
<p><font color="red">
Login Failed. MailServer,UserName or password are incorrect.
</font></p>
</center>

<% } %>

<form action="connect.jsp" method="post" >
<center>
<table>
<tr>
  <td>IMAP Mail Server:</td>
  <td><input type="text" name="hostname" size="25"></td>
</tr>
<tr>
  <td>Username:</td>
  <td><input type="text" name="username" size="25"></td>
</tr>
<tr>
  <td>Password:</td>
  <td><input type="password" name="password" size="25"></td>
</tr>
</table>
</center>

<center><br>
  <input type="submit" value="Login">
  <input type="reset" name="Reset" value="Reset">
</center>

</form>
</body></html>
