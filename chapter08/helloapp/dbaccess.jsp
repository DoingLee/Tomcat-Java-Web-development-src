<!--首先导入一些必要的packages-->
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<!--告诉编译器使用SQL包-->
<%@ page import="java.sql.*"%>
<!--设置中文输出-->
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
  //加载驱动程序，下面的代码加载MySQL驱动程序
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
  //增加新记录
  stmt.executeUpdate("insert into BOOKS (ID,NAME,TITLE,PRICE) values('999','Tom','Tomcat Bible',44.5)");
                                                       
  //查询记录
  rs = stmt.executeQuery("select ID,NAME,TITLE,PRICE from BOOKS");
  //输出查询结果
  out.println("<table border=1 width=400>");
  while (rs.next()){
    String col1 = rs.getString(1);
    String col2 = rs.getString(2);
    String col3 = rs.getString(3);
    float col4 = rs.getFloat(4);
    //打印所显示的数据
    out.println("<tr><td>"+col1+"</td><td>"+col2+"</td><td>"+col3+"</td><td>"+col4+"</td></tr>");
  }
  out.println("</table>");

  //删除新增加的记录
  stmt.executeUpdate("delete from BOOKS where ID='999'");

  //关闭数据库连接
  rs.close();
  stmt.close();
  con.close();
}catch(Exception e){out.println(e.getMessage());}

%>
</body>
</html>
