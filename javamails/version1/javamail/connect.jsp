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

//获得Store对象
Store store = mailsession.getStore("imap");
%>
  
<% 
try{
  //连接邮件服务器
  store.connect(hostname,username, password);
}catch(Exception e){
  request.setAttribute("loginfail","true");
%>

 <jsp:forward page="login.jsp" />

<%
}
%>

<%
// 在MailUserData对象中保存Mail Session对象和Store对象
mud.setSession(mailsession);
mud.setStore(store);
//创建并打开默认的Trash、Draft和sendbox邮件夹
Folder folder=store.getFolder("Trash");
if(!folder.exists())folder.create(Folder.HOLDS_MESSAGES);

folder=store.getFolder("SendBox");
if(!folder.exists())folder.create(Folder.HOLDS_MESSAGES);

folder=store.getFolder("Draft");
if(!folder.exists())folder.create(Folder.HOLDS_MESSAGES);

folder.open(Folder.READ_WRITE);

//把URL保存到MailUserData对象中
URLName url = new URLName("imap",hostname, -1, "inbox", username, password);
mud.setURLName(url);

%>

<jsp:forward page="listallfolders.jsp" />