<!--首先导入一些必要的包-->
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<!--设置中文输出-->
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
 
  //建立数据库连接
  Context ctx = new InitialContext();
  DataSource ds =(DataSource)ctx.lookup("java:comp/env/jdbc/BookDB");
  con = ds.getConnection();

  //创建一个SQL声明
  stmt = con.createStatement();
  //增加新记录
  stmt.executeUpdate("insert into BOOKS(ID,NAME,TITLE,PRICE) values ('999','Tom','Tomcat Bible',44.5)");

  //查询记录
  rs = stmt.executeQuery("select ID,NAME,TITLE,PRICE from BOOKS");
  //输出查询结果
  out.println("<table border=1 width=400>");
  while (rs.next()){
    String col1 = rs.getString(1);
    String col2 = rs.getString(2);
    String col3 = rs.getString(3);
    float col4 = rs.getFloat(4);
    
    //转换字符编码
    col1=new String(col1.getBytes("ISO-8859-1"),"GB2312");
    col2=new String(col2.getBytes("ISO-8859-1"),"GB2312");
    col3=new String(col3.getBytes("ISO-8859-1"),"GB2312");

    //打印所显示的数据
    out.println("<tr><td>"+col1+"</td><td>"+col2+"</td><td>"+col3+"</td><td>"+col4+"</td></tr>");
  }

  out.println("</table>");

  //删除新增加的记录
  stmt.executeUpdate("delete from BOOKS where ID='999'");

  //关闭结果集、SQL声明、数据库连接
  rs.close();
  stmt.close();
  con.close();
}catch (Exception e) {out.println(e.getMessage());e.printStackTrace();}

%>
</body>
</html>
