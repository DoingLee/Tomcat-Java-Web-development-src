<%@ page contentType="text/html; charset=GB2312" %>

<%@ include file="common.jsp" %>
<%@ page import="java.util.*" %>

<jsp:useBean id="cart" scope="session" class="mypack.ShoppingCart"/>

<html>
<head><title>TitleShoppingCart</title></head>
<%@ include file="banner.jsp" %>
<%
  String bookId = request.getParameter("Remove");
  if (bookId != null) {
    cart.remove(bookId);
    BookDetails book = bookDB.getBookDetails(bookId);
%>

<font color="red" size="+2">您删除了一本书：<em><%=convert(book.getTitle())%>
</em>
<br>&nbsp;<br>
</font>

<%
}

if (request.getParameter("Clear") != null) {
  cart.clear();
%>

<font color="red" size="+2"><strong>
清空购物车
</strong><br>&nbsp;<br></font>

<%
}
  // Print a summary of the shopping cart
  int num = cart.getNumberOfItems();
  if (num > 0) {
%>

<font size="+2">您的购物车内有<%=num%>本书
</font><br>&nbsp;

<table>
<tr>
<th align=left>数量</th>
<th align=left>书名</th>
<th align=left>价格</th>
</tr>

<%
    Iterator i = cart.getItems().iterator();
    while (i.hasNext()) {
      ShoppingCartItem item = (ShoppingCartItem)i.next();
      BookDetails book = (BookDetails)item.getItem();
%>

<tr>
<td align="right" bgcolor="#ffffff">
<%=item.getQuantity()%>
</td>

<td bgcolor="#ffffaa">
<strong><a href="<%=request.getContextPath()%>/bookdetails.jsp?bookId=<%=book.getBookId()%>">
<%=convert(book.getTitle())%></a></strong>
</td>

<td bgcolor="#ffffaa" align="right">
<%=book.getPrice()%>
</td>

<td bgcolor="#ffffaa">
<strong>
<a href="<%=request.getContextPath()%>/showcart.jsp?Remove=<%=book.getBookId()%>">删除</a></strong>
</td></tr>

<%
    // End of while
}
%>

<tr><td colspan="5" bgcolor="#ffffff"><br></td></tr>

<tr>
<td colspan="2" align="right" bgcolor="#ffffff">总额(元)</td>
<td bgcolor="#ffffaa" align="right"><%=cart.getTotal()%></td>
<td><br></td>
</tr>

</table>

<p>&nbsp;<p>
<strong><a href="<%=request.getContextPath()%>/catalog.jsp">继续购物</a>&nbsp;&nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/cashier.jsp">付账</a>&nbsp;&nbsp;&nbsp;
<a href="<%=request.getContextPath()%>/showcart.jsp?Clear=clear">清空购物车</a></strong>
<%
} else {
%>

<font size="+2">您的购物车目前为空</font>
<br>&nbsp;<br>
<a href="<%=request.getContextPath()%>/catalog.jsp">继续购物</a>

<%
  // End of if
  }
%>

</body>
</html>
