<%@ page contentType="text/html; charset=GB2312" %>
<%@ include file="common.jsp" %>

<html>
<head><title>Bookstore</title></head>
<%@ include file="banner.jsp" %>

<center>
<p><b><a href="<%=request.getContextPath()%>/catalog.jsp">�쿴������Ŀ</a></b>

<FORM  action=bookdetails.jsp method="POST">
<h3>�������ѯ��Ϣ</h3>
<b>��ı��:</b>
<input type="text" size="20" name="bookId"  value="" ><br><br>
<center><input type=submit  value="��ѯ"></center>
</form>
</center>

</body>
</html>
