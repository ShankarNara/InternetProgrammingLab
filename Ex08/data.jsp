<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<head>
<title>SQL database</title>
</head>

<body>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" 
	url="jdbc:mysql://localhost/StudTable" user="root" password="ssn"/>

<sql:query var="rs" dataSource="${db}">
select * from StudTable;
</sql:query>	

<table border="1" width="100%">
	<tr>
	<th>ID</th>
	<th>Name</th>
	</tr>

	<c:forEach var="row" items="${rs.rows}">
	<tr>
	<td> <c:out value="${row.id}"/></td>
	<td> <c:out value="${row.name}"/></td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
