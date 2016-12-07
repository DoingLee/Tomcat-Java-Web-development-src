<%@ page contentType="text/html; charset=GB2312" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head><title>update</title></head>
<body>

<sql:setDataSource  
url="jdbc:mysql://localhost:3306/BookDB?useUnicode=true&characterEncoding=GB2312"
driver="com.mysql.jdbc.Driver"
user="dbuser"
password="1234"
/>

<!-- 更新记录 -->
<sql:update  var="result"
  sql="update BOOKS set PRICE=PRICE-10 where SALE_AMOUNT>10000" />

一共更新了${result}条记录。<br>

<!-- 添加记录 -->
<sql:update  var="result" >
 insert into BOOKS(ID,NAME,TITLE,PRICE,YR,DESCRIPTION,SALE_AMOUNT) values(?,?,?,?,?,?,?)
 <sql:param>207</sql:param> 
 <sql:param>王小亚</sql:param>
 <sql:param>Java编程</sql:param>
 <sql:param>60</sql:param>
 <sql:param>2008</sql:param>
 <sql:param>好书</sql:param>
 <sql:param>20000</sql:param>
</sql:update>
一共添加了${result}条记录。<br>


<!-- 删除记录 -->
<sql:update  var="result" >
  delete from BOOKS where SALE_AMOUNT>10000
</sql:update>
一共删除了${result}条记录。<br>

</body>
</html>
