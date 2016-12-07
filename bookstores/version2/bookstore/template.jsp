<%@ page contentType="text/html; charset=GB2312" %>


<%@ taglib uri="/mytaglib" prefix="mm" %>
<%@ page errorPage="errorpage.jsp" %>
<%@ page import="java.util.*" %>
<%@ include file="screendefinitions.jsp" %>
<html>
<head>
<title>
        <mm:insert definition="bookstore" parameter="title"/>
</title>
</head>
        <mm:insert definition="bookstore" parameter="banner"/>
        <mm:insert definition="bookstore" parameter="body"/>
</body>
</html>
