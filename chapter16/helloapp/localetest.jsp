<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="javax.servlet.jsp.jstl.core.Config" %>
<%@ page import="java.util.Locale" %>


<fmt:setLocale value="${header['accept-language']}"  scope="session" />

1:${sessionScope['javax.servlet.jsp.jstl.fmt.locale.session'].language}
<p>

<%
Locale locale=(Locale)Config.find(pageContext,Config.FMT_LOCALE);
%>
2:<%=locale.getLanguage()%>