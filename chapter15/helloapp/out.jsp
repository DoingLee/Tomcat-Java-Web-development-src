<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- ��1��out��ǩ --%>
<c:out value="${param.username}" default="unknown" />

&nbsp;&nbsp;

<%--��2��out��ǩ --%>
<c:out value="${param.username}">
  unknown
</c:out>
