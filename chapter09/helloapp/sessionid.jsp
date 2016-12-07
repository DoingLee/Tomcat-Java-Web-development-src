<%-- 
<%@ page session= "false" %>

--%>
<%
Cookie[] cookies = request.getCookies();
if(cookies==null){
  out.println("no cookie");
  return;
}

for(int i = 0; i < cookies.length; i++){
%>

  <p>
  <b>Cookie name:</b>
  <%= cookies[i].getName() %>

  <b>Cookie value:</b>
  <%= cookies[i].getValue() %>
  </p>
  <p>
  <b>max age in seconds:</b>
  <%= cookies[i].getMaxAge() %>
  </p>
<%
}
%>


