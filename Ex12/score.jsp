<%@ page import="java.util.*,java.util.List,java.util.ArrayList" %>
<html>
<body>
<%
    int score = (int)session.getAttribute("score");
    int total = (int)session.getAttribute("length");

    out.println("<h3> Result : </h3>");
    out.println("<h3>You got " + score + " / " + total + " questions right</h3>");

%>

</body>
</html>