<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- 第1个out标签 --%>
<c:out value="${param.username}" default="unknown" />

&nbsp;&nbsp;

<%--第2个out标签 --%>
<c:out value="${param.username}">
  unknown
</c:out>
