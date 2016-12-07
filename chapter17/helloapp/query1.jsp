<%@ page contentType="text/html; charset=GB2312" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>query</title></head>
<body>

<sql:setDataSource  dataSource="jdbc/BookDB" var="myRes"/>
<sql:query sql="select ID,NAME,TITLE,PRICE from BOOKS" 
startRow="1" maxRows="4"  var="books" dataSource="${myRes}" />

共有${books.rowCount}本书。<br>
<table border="1">
<tr>
<th>${books.columnNames[0]}</th>
<th>${books.columnNames[1]}</th>
<th>${books.columnNames[2]}</th>
<th>${books.columnNames[3]}</th>
</tr>

<c:forEach var="book" items="${books.rows}">
<tr>
<td>${book.ID}</td>
<td>${book.NAME}</td>
<td>${book.TITLE}</td>
<td>${book.PRICE}</td>
</tr>
</c:forEach>

</table>
</body>
</html>
