<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="mypack.*" %>
<%@ page import="javax.mail.*" %>
<%@ page import="javax.mail.internet.*" %>
<%@ page import="javax.activation.*" %>
<%@ page errorPage="errorpage.jsp" %>


<jsp:useBean id="mud" scope="session" class="mypack.MailUserData"/>

<%
//���Ự�Ƿ��Ѿ�ʧЧ�������û��Ƿ��Ѿ�����
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
