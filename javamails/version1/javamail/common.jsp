<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="mypack.*" %>
<%@ page import="javax.mail.*" %>
<%@ page import="javax.mail.internet.*" %>
<%@ page import="javax.activation.*" %>
<%@ page errorPage="errorpage.jsp" %>


<jsp:useBean id="mud" scope="session" class="mypack.MailUserData"/>

<%
//检查会话是否已经失效，或者用户是否已经登入
if(mud.getStore()==null){
%>

<font color="red" size="4">

<b>Error Information:</b>
The page you visit expires or you do not login yet.
Please <a href=login.jsp>login again</a>

</font>

<%
return; }
%>
