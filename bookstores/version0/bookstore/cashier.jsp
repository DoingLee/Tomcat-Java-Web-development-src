<%@ page contentType="text/html; charset=GB2312" %>

<%@ include file="common.jsp" %>
<%@ page import="java.util.*" %>


<jsp:useBean id="cart" scope="session" class="mypack.ShoppingCart"/>

<html>
<head><title>TitleCashier</title></head>
<%@ include file="banner.jsp" %>
<p>��һ��������<%=cart.getNumberOfItems() %>����</P>
<p>��Ӧ֧���Ľ��Ϊ<%=cart.getTotal() %>Ԫ</p>

<form action="<%=request.getContextPath()%>/receipt.jsp" method="post">
<table>
<tr>
<td><strong>���ÿ��û���</strong></td>
<td><input type="text" name="cardname" value="guest" size="19"></td>
</tr>
<tr>
<td><strong>���ÿ��˺�</strong></td>
<td><input type="text" name="cardnum" value="xxxx xxxx xxxx xxxx" size="19"></td>
</tr>
<tr>
<td></td>
<td><input type="submit" value="�ݽ�"></td>
</tr>
</table>
</form>
</body>
</html>
