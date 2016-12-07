<%@ page import="mypack.CounterBean" %>

<html>
<head>
<title>
Counter
</title>
</head>
<jsp:useBean id="myRequestBean" scope="request" class="mypack.CounterBean" />
<body>

Current count value is :<jsp:getProperty name="myRequestBean" property="count" />

</body>
</html>
