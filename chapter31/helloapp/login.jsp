<%@ page import="org.apache.log4j.Logger" %>

<html>
<head>
  <title>helloapp</title>
</head>
<body >
<%
  Logger helloappLogger =
    Logger.getLogger("helloappLogger");
    // Log Messages using the Parent Logger
    helloappLogger.debug("This is a log message from the " +
      helloappLogger.getName());
    helloappLogger.info("This is a log message from the " +
      helloappLogger.getName());
    helloappLogger.warn("This is a log message from the " +
      helloappLogger.getName());
    helloappLogger.error("This is a log message from the " +
      helloappLogger.getName());
    helloappLogger.fatal("This is a log message from the " +
      helloappLogger.getName());

%>
        <br>
       <form name="loginForm" method="post" action="hello.jsp">
        <table>
 	<tr><td><div align="right">User Name:</div></td><td> <input type="text" name="username"></td></tr>
        <tr><td><div align="right">Password:</div></td><td><input type="password" name="password"></td></tr>
        <tr><td></td><td><input type="Submit" name="Submit" value="Submit"></td></tr>
        </table>
	</form>

</body>
</html>
