<%@ tag pageEncoding="GB2312" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="username"  required="true"  fragment="true" %>

<jsp:invoke fragment="username" var="user" />

<c:choose>
  <c:when test="${empty user}"> 
    My friend,
  </c:when>
  <c:otherwise>
    ${user},
  </c:otherwise> 
</c:choose>

<jsp:doBody/>  
