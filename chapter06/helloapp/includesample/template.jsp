<%@ page contentType="text/html; charset=GB2312" %>
<html>
   <head>
      <title><%=titlename %></title>
   </head>
   <body >
      <%-- 最外层Table --%>
      <table width="100%" height="100%">
         <tr>
            <%-- 左侧菜单部分 --%>
            <td width="150" valign="top" align="left" bgcolor="#CCFFCC">
               <%@ include file="sidebar.htm" %>
            </td>
            <%-- 网页右边部分 --%>
            <td height="100%" >
               <table width="100%" height="100%">
                  <tr>
                     <%-- 头部 --%>
                     <td valign="top" height="15%">
                        <%@ include file="header.htm"%> 
                     </td>
                  </tr>
                  <tr>
                     <%-- 主体部分 --%>
                     <td valign="top" >
                        <jsp:include page="<%=bodyfile %>" />
                     </td>
                  </tr>
                  <tr>
                     <%-- 尾部 --%>
                     <td valign="bottom" height="15%">
                        <%@ include file="footer.htm" %>
                     </td>
                  </tr>
               </table>
            </td>
         </tr>
      </table>
   </body>
</html>
