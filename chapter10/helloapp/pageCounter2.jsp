<%@ page import="mypack.CounterBean" %>

<html><head><title>Counter</title></head>
<body>

<jsp:useBean id="myPageBean" scope="page" class="mypack.CounterBean" />
Current count value is :<jsp:getProperty name="myPageBean" property="count" />

</body>
</html>
