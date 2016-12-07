<!--首先导入一些必要的packages-->
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<!--告诉编译器使用SQL包-->
<%@ page import="java.sql.*"%>
<!--设置中文输出-->
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
  //加载驱动程序，下面的代码为加载MySQL驱动程序
  Class.forName("com.mysql.jdbc.Driver");
  //注册MySQL驱动程序
  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
  //用适当的驱动程序连接到数据库
  String dbUrl =  "jdbc:mysql://localhost:3306/BookDB?useUnicode=true&characterEncoding=GB2312";
  String dbUser="dbuser";
  String dbPwd="1234";
  //建立数据库连接
  con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
  //创建一个SQL声明
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
