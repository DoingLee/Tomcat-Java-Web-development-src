<!--���ȵ���һЩ��Ҫ��packages-->
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<!--���߱�����ʹ��SQL��-->
<%@ page import="java.sql.*"%>
<!--�����������-->
<%@ page contentType="text/html; charset=GB2312" %>

<html>
<head>
  <title>dbaccess2.jsp</title>
</head>
<body>
<%
try{
  Connection con;
  Statement stmt;
  ResultSet rs;
  //����������������Ĵ���Ϊ����MySQL��������
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
%>

<%@ include file="pages.jsp" %> 

<%
  stmt.close();
  con.close();
}catch(Exception e){out.println(e.getMessage());}

%>
</body>
</html>
