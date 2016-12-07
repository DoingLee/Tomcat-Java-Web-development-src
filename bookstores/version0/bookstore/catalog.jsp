<%@ page contentType="text/html; charset=GB2312" %>

<%@ include file="common.jsp" %>
<%@ page import="java.util.*" %>

<jsp:useBean id="cart" scope="session" class="mypack.ShoppingCart"/>

<html>
<head><title>BookCatalog</title></head>
 <%@ include file="banner.jsp" %>

<%
  // Additions to the shopping cart
  String bookId = request.getParameter("Add");
  if (bookId != null) {
    BookDetails book = bookDB.getBookDetails(bookId);
    cart.add(bookId, book);
%>
<p><h3>
<font color="red">
您已将 <i><%=convert(book.getTitle())%></i> 加入购物车</font></h3>
<%
}
if (cart.getNumberOfItems() > 0) {
%>

<p><strong><a href="<%=request.getContextPath()%>/showcart.jsp">察看购物车</a>&nbsp;&nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/cashier.jsp">付账</a></p></strong>

<%
}
%>

<h3>请选择想购买的书：</h3>

<table>
<%
  Collection c = bookDB.getBooks();
  Iterator i = c.iterator();
  while (i.hasNext()) {
    BookDetails book = (BookDetails)i.next();
    bookId = book.getBookId();
%>

<tr>
<td bgcolor="#ffffaa">
<a href="<%=request.getContextPath()%>/bookdetails.jsp?bookId=<%=bookId%>"><strong>
<%=convert(book.getTitle())%>&nbsp;</strong></a></td>

<td bgcolor="#ffffaa" rowspan=2>


<td bgcolor="#ffffaa" rowspan=2>
<a href="<%=request.getContextPath()%>/catalog.jsp?Add=<%=bookId%>">&nbsp;加入购物车&nbsp;</a></td></tr>

<tr>
<td bgcolor="#ffffff">
&nbsp;&nbsp;作者：<em><%=convert(book.getName())%>&nbsp;
</em></td></tr>

<% } %>

</table>

</body>
</html>
