<%@ include file="common.jsp" %>

<html>
<head><title>listallfolders</title></head>
<body>
<center><font size="+3"><b>Folder List</b></font></center>
<p>
<%@ include file="link.jsp" %>

<%
String operation=request.getParameter("operation");
String folderName=request.getParameter("folder");
String newFolderName=request.getParameter("newFolderName");
String error=null;
try{
  if(operation!=null && operation.equals("create"))
    mud.doCreateFolder(newFolderName);
  if(operation!=null && operation.equals("delete"))
    mud.doDeleteFolder(folderName);
  if(operation!=null && operation.equals("rename"))
    mud.doRenameFolder(folderName,newFolderName);
}catch(Exception e){
  out.println("<font color='red'>"+e.getMessage()+"</font><p>");
}
%>

<%
Folder folder=null;
Store store=mud.getStore();
folder = store.getDefaultFolder();
if (folder == null)
  throw new MessagingException("No folder is available");
Folder[] f = folder.list("%");
%>

<table width="75%" border=1 align=left>
<tr bgcolor="#FFCC66">
<td rowspan=1 width="25%" ><b>FolderName</b></td>
<td rowspan=1 width="25%" ><b>Total Messages</b></td>
<td rowspan=1 width="25%" ><b>Unread Messages</b></td>
</tr>

<% for(int i=0; i<f.length;i++){ %>

<tr valigh=middle bgcolor="#FFFFCC">
<td>
<a href="listonefolder.jsp?folder=<%=f[i].getName()%>">
<%=f[i].getName()%></a>
</td>
<td><%=f[i].getMessageCount()%></td>
<td><%=f[i].getUnreadMessageCount()%></td>
</tr>

<% } %>

<tr>
<td colspan=3>
    
<table width="50%" border=0 align=center>
<tr><td colspan=2 align=center><b><br>Folder Operation</b></td><tr>
<form action="listallfolders.jsp" >
<tr>
<td>select operation:</td>
<td>
<select name="operation">
<option value="create" selected> create folder
<option value="delete" >delete folder
<option value="rename" >rename folder
</select>
</td>
</tr>

<tr>
<td>select folder:</td>
<td>
<select name="folder">

<%
for(int i=0;i<f.length;i++){
  if(!f[i].getName().equalsIgnoreCase("inbox") 
    && !f[i].getName().equalsIgnoreCase("Draft")
    && !f[i].getName().equalsIgnoreCase("Trash") 
    && !f[i].getName().equalsIgnoreCase("SendBox")){
   
    if(i==0)
      out.println("<OPTION VALUE=\""+f[i].getName()+" selected\">"+f[i].getName());
    else
      out.println("<OPTION VALUE=\""+f[i].getName()+" \">"+f[i].getName());
  }
}
%>

</select></td></tr>

<tr>
<td>new folder name:</td>
<td><input type="text" name="newFolderName"></td>
</tr>
<tr>
<td colspan=2 align=center>
<input type="submit" name="submit" value="submit">
</td>
</tr>
</form>
</table>

</td>
</tr>
</table>

</body></html>