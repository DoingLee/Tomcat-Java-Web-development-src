<%@ page import="mypack.*" %>
<%@ page import="java.util.Properties" %>
<%@ page errorPage="errorpage.jsp" %>
<%@ page import="mypack.*" %>
<%@ page import="java.util.Properties" %>
<%@ page errorPage="errorpage.jsp" %>


<jsp:useBean id="bookDB" scope="application" class="mypack.BookDBDelegate"/>

<%!
public String convert(String s){
  try{
    return new String(s.getBytes("ISO-8859-1"),"GB2312");
  }catch(Exception e){return null;}
}

%>
