<%@ page import="javax.mail.*" %>
<%@ page import="javax.mail.internet.*" %>
<%@ page import="javax.activation.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.naming.*" %>

<%@ page errorPage="errorpage.jsp" %>
<jsp:useBean id="mud" scope="session" class="mypack.MailUserData"/>

<%
String hostname = request.getParameter("hostname");
String username = request.getParameter("username");
String password = request.getParameter("password");

Context ctx = new InitialContext();
if(ctx == null )
  throw new Exception("No Context");
Session mailsession =(Session)ctx.lookup("java:comp/env/mail/session");

//���Store����
Store store = mailsession.getStore("imap");
%>
  
<% 
try{
  //�����ʼ�������
  store.connect(hostname,username, password);
}catch(Exception e){
  request.setAttribute("loginfail","true");
%>

 <jsp:forward page="login.jsp" />

<%
}
%>

<%
// ��MailUserData�����б���Mail Session�����Store����
mud.setSession(mailsession);
mud.setStore(store);
//��������Ĭ�ϵ�Trash��Draft��sendbox�ʼ���
Folder folder=store.getFolder("Trash");
if(!folder.exists())folder.create(Folder.HOLDS_MESSAGES);

folder=store.getFolder("SendBox");
if(!folder.exists())folder.create(Folder.HOLDS_MESSAGES);

folder=store.getFolder("Draft");
if(!folder.exists())folder.create(Folder.HOLDS_MESSAGES);

folder.open(Folder.READ_WRITE);

//��URL���浽MailUserData������
URLName url = new URLName("imap",hostname, -1, "inbox", username, password);
mud.setURLName(url);

%>

<jsp:forward page="listallfolders.jsp" />