<!--���ȵ���һЩ��Ҫ��packages-->
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<!--���߱�����ʹ��SQL��-->
<%@ page import="java.sql.*"%>
<!--�����������-->
<%@ page contentType="text/html; charset=GB2312" %>

<html>
<head>
  <title>dbaccess.jsp</title>
</head>
<body>
<%
try{
  Connection con;
  Statement stmt;
  ResultSet rs;
  //����������������Ĵ������MySQL��������
  Class.forName("com.mysql.jdbc.Driver");
  //ע��MySQL��������
  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
  //���ʵ��������������ӵ����ݿ�
  String dbUrl =  "jdbc:mysql://localhost:3306/BookDB?useUnicode=true&characterEncoding=GB2312";
  String dbUser="dbuser";
  String dbPwd="1234";
  //�������ݿ�����
  con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
  //����һ��SQL����
  stmt = con.createStatement();
  //�����¼�¼
  stmt.executeUpdate("insert into BOOKS (ID,NAME,TITLE,PRICE) values('999','Tom','Tomcat Bible',44.5)");
                                                       
  //��ѯ��¼
  rs = stmt.executeQuery("select ID,NAME,TITLE,PRICE from BOOKS");
  //�����ѯ���
  out.println("<table border=1 width=400>");
  while (rs.next()){
    String col1 = rs.getString(1);
    String col2 = rs.getString(2);
    String col3 = rs.getString(3);
    float col4 = rs.getFloat(4);
    //��ӡ����ʾ������
    out.println("<tr><td>"+col1+"</td><td>"+col2+"</td><td>"+col3+"</td><td>"+col4+"</td></tr>");
  }
  out.println("</table>");

  //ɾ�������ӵļ�¼
  stmt.executeUpdate("delete from BOOKS where ID='999'");

  //�ر����ݿ�����
  rs.close();
  stmt.close();
  con.close();
}catch(Exception e){out.println(e.getMessage());}

%>
</body>
</html>
