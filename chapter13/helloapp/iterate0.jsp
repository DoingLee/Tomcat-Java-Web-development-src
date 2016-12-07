<%@page contentType="text/html; charset=GB2312" %>
<%@page import="mypack.BookDetails" %>
<%@page import="java.util.*" %>
<%  
  BookDetails book1=new BookDetails("201", "孙卫琴", 
      "Java面向对象编程", 65, 2006, "让读者由浅入深掌握Java语言", 20000);
  BookDetails book2=new BookDetails("202", "孙卫琴", 
     "精通Struts", 49, 2004, "真的很棒", 80000);
  BookDetails book3=new BookDetails("203", "孙卫琴", 
     "Tomcat与JavaWeb开发技术详解", 45, 2004, "关于JavaWeb开发的最畅销书", 40000);
  BookDetails book4=new BookDetails("204", "孙卫琴", 
     "Java网络编程精解",55, 2007, "很值得一看", 20000);

  List books=new ArrayList();  //创建待显示的集合
  books.add(book1); 
  books.add(book2); 
  books.add(book3); 
  books.add(book4); 
%>  

<html><head><title>booklist</title></head>
<body>
  <table border="1">
    <caption><b>书的信息</b></caption>
    <tr>
      <th>作者</th>
      <th>书名</th>
      <th>价格</th>
      <th>读者评价</th>  
    </tr>
    <%
      for(int i=0;i<books.size();i++){
        BookDetails book=(BookDetails)books.get(i);
        pageContext.setAttribute("book",book,PageContext.PAGE_SCOPE);
    %>
      <tr>
        <td>${book.name}</td>
        <td>${book.title}</td>
        <td>${book.price}</td>
        <td>${book.description}</td>
      </tr>
    <% } %>
  </table>
</body></html>
