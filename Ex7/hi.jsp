<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<p> Hi this is JSP</p>
</body>
<%
String name=request.getParameter("t1");
out.println("welcome  "+name);
%>
<c:out value="${param.t1}"/>
</html>
