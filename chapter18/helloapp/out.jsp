<%@ page contentType="text/html; charset=GB2312" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>out</title></head>
<body>

1: ${fn:escapeXml("<b>��ʾ������</b>")} <br>
2: <c:out value="<b>��ʾ������</b>" escapeXml="true" /> <br>
3: ${"<b>��ʾ������</b>"} <br>


</body>
</html>
