<!--���ȵ���һЩ��Ҫ�İ�-->
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<!--�����������-->
<%@ page contentType="text/html; charset=GB2312" %>
<html>
<head>
  <TITLE>dbaccess1.jsp</TITLE>
</head>
<body>
<%
try{
  Connection con;
  Statement stmt;
  ResultSet rs;
 
  //�������ݿ�����
  Context ctx = new InitialContext();
  DataSource ds =(DataSource)ctx.lookup("java:comp/env/jdbc/BookDB");
  con = ds.getConnection();

  //����һ��SQL����
  stmt = con.createStatement();
  //�����¼�¼
  stmt.executeUpdate("insert into BOOKS(ID,NAME,TITLE,PRICE) values ('999','Tom','Tomcat Bible',44.5)");

  //��ѯ��¼
  rs = stmt.executeQuery("select ID,NAME,TITLE,PRICE from BOOKS");
  //�����ѯ���
  out.println("<table border=1 width=400>");
  while (rs.next()){
    String col1 = rs.getString(1);
    String col2 = rs.getString(2);
    String col3 = rs.getString(3);
    float col4 = rs.getFloat(4);
    
    //ת���ַ�����
    col1=new String(col1.getBytes("ISO-8859-1"),"GB2312");
    col2=new String(col2.getBytes("ISO-8859-1"),"GB2312");
    col3=new String(col3.getBytes("ISO-8859-1"),"GB2312");

    //��ӡ����ʾ������
    out.println("<tr><td>"+col1+"</td><td>"+col2+"</td><td>"+col3+"</td><td>"+col4+"</td></tr>");
  }

  out.println("</table>");

  //ɾ�������ӵļ�¼
  stmt.executeUpdate("delete from BOOKS where ID='999'");

  //�رս������SQL���������ݿ�����
  rs.close();
  stmt.close();
  con.close();
}catch (Exception e) {out.println(e.getMessage());e.printStackTrace();}

%>
</body>
</html>
