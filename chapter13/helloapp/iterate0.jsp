<%@page contentType="text/html; charset=GB2312" %>
<%@page import="mypack.BookDetails" %>
<%@page import="java.util.*" %>
<%  
  BookDetails book1=new BookDetails("201", "������", 
      "Java���������", 65, 2006, "�ö�����ǳ��������Java����", 20000);
  BookDetails book2=new BookDetails("202", "������", 
     "��ͨStruts", 49, 2004, "��ĺܰ�", 80000);
  BookDetails book3=new BookDetails("203", "������", 
     "Tomcat��JavaWeb�����������", 45, 2004, "����JavaWeb�����������", 40000);
  BookDetails book4=new BookDetails("204", "������", 
     "Java�����̾���",55, 2007, "��ֵ��һ��", 20000);

  List books=new ArrayList();  //��������ʾ�ļ���
  books.add(book1); 
  books.add(book2); 
  books.add(book3); 
  books.add(book4); 
%>  

<html><head><title>booklist</title></head>
<body>
  <table border="1">
    <caption><b>�����Ϣ</b></caption>
    <tr>
      <th>����</th>
      <th>����</th>
      <th>�۸�</th>
      <th>��������</th>  
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
