<%@ include file="common.jsp" %>
<html>
<head><title>show message</title></head>
<body >

<%
Folder folder=mud.getCurrFolder();
Message currmsg=null;
int msgNum=1;
String messageindex=request.getParameter("messageindex");

if(messageindex!=null){
  msgNum=Integer.parseInt(messageindex);
  currmsg=folder.getMessage(msgNum);
  mud.setCurrMsg(currmsg);
}else
  currmsg=mud.getCurrMsg();

PMessage displayMsg=new PMessage(currmsg);
%>

<center><font size="+3"><b>
<%
  out.println("Message in "+folder.getName()+" folder "); 
%>
</b></font></center><p>

<%@ include file="link.jsp" %>

<a href="compose.jsp?reply=true" >Reply</a>
<a href="listonefolder.jsp?delIndex<%=msgNum%>=on" >Delete</a>

<%-- 显示邮件信息--%>
<table width=90%>
<tr>
<td>
<b>Date:</b> <%=displayMsg.getDate()%><br>
<b>From:</b> <%=displayMsg.getFrom()%><br>
<b>To:</b> <%=displayMsg.getTo()%><br>
<b>CC:</b> <%=displayMsg.getCC()%><br>
<b>Subject:</b> <%=displayMsg.getSubject()%><br>
<pre><%=displayMsg.getText()%></pre>
</td>
</tr>
</table>
</body></html>