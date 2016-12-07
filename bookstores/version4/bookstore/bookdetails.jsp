<%@ page contentType="text/html; charset=GB2312" %>
<%@ include file="common.jsp" %>
<%@ page import="java.util.*" %>

<html>
<head><title>TitleBookDescription</title></head>
<%@ include file="banner.jsp" %>
<br>
<%
    //Get the identifier of the book to display
    String bookId = request.getParameter("bookId");
    if(bookId==null)bookId="201";
    BookDetails book = bookDB.getBookDetails(bookId);
%>

<% 
   if(book==null)
   { 
%>
    <p>���"<%=bookId%>"�����ݿ��в�����<p>
    <strong><a href="<%=request.getContextPath()%>/catalog.jsp">��������</a></strong>
<% 
     return;
   }
%>

<p>������<%=convert(book.getTitle())%></p>
����: <em><%=convert(book.getName())%> </em>&nbsp;&nbsp;
(<%=book.getYear()%>)<br>
<p>�۸�Ԫ����<%=book.getPrice()%></p>
<p>����������<%=book.getSaleAmount()%></p>
<p>���ۣ�<%=convert(book.getDescription())%></p>


<p><strong><a href="<%=request.getContextPath()%>/catalog.jsp?Add=<%=bookId%>">���빺�ﳵ</a>&nbsp; &nbsp; &nbsp;
<a href="<%=request.getContextPath()%>/catalog.jsp">��������</a></p></strong>
</body>
</html>