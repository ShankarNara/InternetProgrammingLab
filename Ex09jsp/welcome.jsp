<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<body>
<sql:setDataSource var="snapshot"
		driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/StudTable"
		user="root"
		password="ssn" />
<sql:query dataSource="${snapshot}" var ="result" >
select * from Student;
</sql:query>
<center>
<c:out value="CONTENTS of table student: " />
      <table border = "1">
         <tr>
            <th>Rollno</th>
            <th>name</th>
         </tr>
<c:forEach var="row" items="${result.rows}">
 <tr>
<td><c:out value="${row.id}" /></td>  <td><c:out value="${row.name}" /></td>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>
