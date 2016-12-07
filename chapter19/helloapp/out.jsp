<%@ taglib prefix="mm" tagdir="/WEB-INF/tags" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<body>
 
<mm:precode>
<jsp:attribute name="preserve">  
  <b>${code}</b>    </jsp:attribute>  

<jsp:body>  
  ${fn:toUpperCase("  Tomcat  ")}
</jsp:body>  
</mm:precode>

</body> </html> 
