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
���ѽ� <i><%=convert(book.getTitle())%></i> ���빺�ﳵ</font></h3>
<%
}
if (cart.getNumberOfItems() > 0) {
%>

<p><strong><a href="<%=request.getContextPath()%>/showcart.jsp">�쿴���ﳵ</a>&nbsp;&nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/cashier.jsp">����</a></p></strong>

<%
}
%>

<h3>��ѡ���빺����飺</h3>

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
<a href="<%=request.getContextPath()%>/catalog.jsp?Add=<%=bookId%>">&nbsp;���빺�ﳵ&nbsp;</a></td></tr>

<tr>
<td bgcolor="#ffffff">
&nbsp;&nbsp;���ߣ�<em><%=convert(book.getName())%>&nbsp;
</em></td></tr>

<% } %>

</table>

</body>
</html>
