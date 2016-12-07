<%@attribute name="preserve" fragment="true" %> 
<%@variable name-given="code" scope="NESTED" %>  

<jsp:doBody var="code" />

<table border="1"><tr><td>

<pre><jsp:invoke fragment="preserve"/></pre>

</td></tr></table> 
