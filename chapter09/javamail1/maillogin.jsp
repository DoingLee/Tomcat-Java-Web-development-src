<%@ page contentType="text/html; charset=GB2312" %>
<html><head><title>maillogin</title></head>

<body bgcolor="#FFFFFF" onLoad="document.loginForm.username.focus()">

<%
 String name="";
if(!session.isNew()){
  name=(String)session.getAttribute("username");
 if(name==null)name="";
}
%>
<p>欢迎光临邮件系统</p>
<p>Session ID:<%=session.getId()%></p>

  <table width="500" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td>
        <table width="500" border="0" cellspacing="0" cellpadding="0">
          <form name="loginForm" method="post" action="mailcheck.jsp">
          <tr>
            <td width="401"><div align="right">User Name:&nbsp;</div></td>
            <td width="399"><input type="text" name="username" value="<%=name%>" ></td>
          </tr>
          <tr>
            <td width="401"><div align="right">Password:&nbsp;</div></td>
            <td width="399"><input type="password" name="password"></td>
          </tr>
          <tr>
            <td width="401">&nbsp;</td>
            <td width="399"><br><input type="Submit" name="Submit"  value="提交"></td>
          </tr>
          </form>
        </table>
      </td>
    </tr>
  </table>

</body></html>
