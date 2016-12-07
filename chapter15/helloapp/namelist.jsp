<%@ page contentType="text/html; charset=GB2312" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.HashSet" %>

<%
HashSet names=new HashSet();
names.add("Tom");
names.add("Mike");
names.add("Linda");
%>

<table border="1">
  <tr>
   <td>���</td>
   <td>����</td>
   <td>�Ƿ��ǵ�һ��Ԫ��</td>
   <td>�Ƿ������һ��Ԫ��</td>
   <td>Ԫ�ص�ֵ</td>
  </tr>

<c:forEach var="name" items="<%=names %>" varStatus="status">
  <tr>
    <td>${status.count} </td>
    <td>${status.index} </td>
    <td>${status.first} </td>
    <td>${status.last} </td>
    <td>
      <c:choose>
        <c:when test="${status.last}">
          <font color="red">${name} </font>
        </c:when>
        <c:otherwise>
          <font color="green">${name} </font>
        </c:otherwise>
      </c:choose>
    </td>
  </tr>
</c:forEach>
</table>
