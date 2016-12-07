<html>
<head><title>hitCounter</title></head>
<body>
   <H1>
   You hit the page:
   <%! int hitcount=1;%>
   <% 
     int count=0;
     hitcount=count++;
   %> 
   <%=hitcount++ %>
 
   times
   </H1>
</body></html>

