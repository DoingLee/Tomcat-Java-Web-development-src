<%@ include file="common.jsp" %>

<html>
<head><title>composemessage</title></head>
<body>
<center><font size="+3"><b>Compose Message</b></font></center><p>
<%@ include file="link.jsp" %>

<%
String operation=request.getParameter("operation");
String reply=request.getParameter("reply");
String edit=request.getParameter("edit");

String to = request.getParameter("to");
String cc = request.getParameter("cc");
String bcc = request.getParameter("bcc");
String subj = request.getParameter("subject");
String text = request.getParameter("text");

PMessage displayMsg=new PMessage();

//发送邮件
if(operation != null && operation.equals("send")) {
  displayMsg=new PMessage(to, cc, bcc, subj,text);
  mud.doSendMessage(displayMsg);
  out.println("Message is sent to "+to);
}

//保存邮件
if(operation != null && operation.equals("save")) {
  displayMsg=new PMessage(to, cc, bcc, subj,text);
  mud.doSaveMessage(displayMsg);
  out.println("Message is saved to Draft");
}

//获得回复邮件的初稿
if(reply!=null){
  Message currmsg=mud.getCurrMsg();
  displayMsg=new PMessage(currmsg.reply(true));
}

//编辑草稿邮件
if(edit!=null) {
  displayMsg=new PMessage(mud.getCurrMsg());
}

%>

<form action="compose.jsp" method="post">
<table border="0" width="100%">
<tr>
<td width="16%" height="22"><p align="right"><b>to:</b></td>
<td width="84%" height="22">
<input type="text" name="to" value="<%=displayMsg.getTo()%>" size="30" >
</td>
</tr>

<tr>
<td width="16%"><p align="right"><b>cc:</b></td>
<td width="84%">
<input type="text" name="cc" value="<%=displayMsg.getCC()%>" size="30">
</td>
</tr>

<tr>
<td width="16%"><p align="right"><b>bcc:</b></td>
<td width="84%">
<input type="text" name="bcc" value="<%=displayMsg.getBCC()%>" size="30">
</td>
</tr>

<tr>
<td width="16%"><p align="right"><b>subject:</b></td>
<td width="84%">
<input type="text" name="subject" value="<%=displayMsg.getSubject()%>" size="30">
</td>
</tr>

<tr>
<td width="16%">&nbsp;</td>
<td width="84%">
<textarea name="text" rows="5" cols="40"> <%=displayMsg.getText()%></textarea>
</td>
</tr>

</table>

<center>
<b>
<input type="radio" name="operation" value="save">save draft
<input type="radio" name="operation" value="send" checked>send 
</b>
<input type="submit" name="submit" value="submit">
<input type="reset" name="reset" value="reset">
</center>

</form>
</body></html>
