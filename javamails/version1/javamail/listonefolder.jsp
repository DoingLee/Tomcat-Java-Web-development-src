<%@ include file="common.jsp" %>

<html>
<head><title>listonefolder</title></head>
<body>
<%
String folderName=request.getParameter("folder");
SimpleDateFormat df = new SimpleDateFormat("yy.MM.dd 'at' HH:mm:ss ");
Folder f=null;
if(folderName!=null){
  f=mud.getStore().getFolder(folderName);
  mud.setCurrFolder(f);
}else{
  f=mud.getCurrFolder();
  folderName=f.getName();
}

if(!f.isOpen())f.open(Folder.READ_WRITE);
int msgCount = f.getMessageCount();
int unReadCount = f.getUnreadMessageCount();

//删除邮件
int arrayOpt[]=new int[msgCount];
for(int i=1;i<=msgCount;i++){
   String optS=request.getParameter("delIndex"+i);
   if(optS!=null) arrayOpt[i-1]=1;
}
mud.doDeleteMessage(arrayOpt,f);

//刷新邮件总数以及未读邮件总数
if(f.isOpen())f.close(true);
f.open(Folder.READ_WRITE);
msgCount = f.getMessageCount();
unReadCount = f.getUnreadMessageCount();

%>

<center>
<font size="+3"><b>CurrentFolder:<%=folderName%></b></font>
</center><p>

<%@ include file="link.jsp" %>

<b>Total Messages:<%=msgCount%></b>
<b>Unread Messages:<%=unReadCount%></b>

<form action="listonefolder.jsp">
<table cellpadding=1 cellspacing=1 width="100%" border=1>
<tr bgcolor="ffffcc">
  <td width="5%" ></td>
  <td width="35%" ><b>Sender</b></td>
  <td width="20%" ><b>Date</b></td>
  <td width="30%" ><b>Subject</b></td>
  <td width="10%" ><b>Size</b></td>
</tr>

<%
Message m = null;
//显示每封邮件的头信息
for (int i = 1; i <= msgCount; i++) {
  m = f.getMessage(i);

  //如果邮件设了DELETED标志，就不用显示
  if (m.isSet(Flags.Flag.DELETED))
    continue;
%>


<tr valign=middle >
<%--opt --%>
<td width=5% ><input type=checkbox name="delIndex<%=i%>"></td>

<%-- from --%>
<td width="35%">
<% if(!m.isSet(Flags.Flag.SEEN)) out.print("<b>"); %>
<% out.println((m.getFrom() != null) ? m.getFrom()[0].toString() : " "); %>
<% if(!m.isSet(Flags.Flag.SEEN))out.print("</b>"); %>
</td>

<%--date --%>
<td width="20%">
<%
if(!m.isSet(Flags.Flag.SEEN))out.println("<b>");

out.println(
  df.format((m.getSentDate()!=null) ? m.getSentDate() : m.getReceivedDate())); 

if(!m.isSet(Flags.Flag.SEEN))out.println("</b>");
%>

</td>

<%--subject & link --%>
<td width="30%">
<%
String link="";
if(f.getName().equals("Draft")){
  link="compose.jsp?edit=true";
  mud.setCurrMsg(m);
}else 
  link="showmessage.jsp" + "?messageindex=" + i;

if(!m.isSet(Flags.Flag.SEEN))out.println("<b>");

out.println("<a href="+link+">" +
        ((m.getSubject() != null)&& !m.getSubject().equals("") ?
                          m.getSubject() : "<i>No Subject</i></a>"));

if(!m.isSet(Flags.Flag.SEEN))out.println("</b>");

%>
</td>

<%-- size--%>
<td width="10%">

<%
if(!m.isSet(Flags.Flag.SEEN))out.println("<b>");

out.println(m.getSize()+"Bytes");

if(!m.isSet(Flags.Flag.SEEN))out.println("</b>");
%>

</td>
</tr>

<% } %>

</table>
<p><input type="submit" name="submit" value="delete messages"></form>
</body></html>
