<%@ page contentType="text/html; charset=GB2312" %>
<%@ page errorPage="errorpage.jsp" %>

<html><head><title>sum.jsp</title></head>
<body>
    <%!
            private int toInt(String num){
              return Integer.valueOf(num).intValue();
            }
    %>
    <%
        int num1=toInt(request.getParameter("num1"));
        int num2=toInt(request.getParameter("num2"));
    %>

    <p>
         ������Ϊ:<%=num1%>+<%=num2%>=<%=(num1+num2)%>
    </p>
</body></html>
