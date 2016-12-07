<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="messages" />
<fmt:setBundle basename="resource" var="myres"/>


1:<fmt:message key="myword" /> <br>

<fmt:bundle basename="resource">
2:<fmt:message key="myword" /> <br>
</fmt:bundle>

3:<fmt:message key="myword" bundle="${myres}" /> <br>
