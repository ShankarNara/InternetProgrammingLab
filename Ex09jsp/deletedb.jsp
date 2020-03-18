<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<body>
<sql:setDataSource var="snapshot"
		driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost/StudTable"
		user="root"
		password="ssn" />
<sql:update dataSource="${snapshot}" var ="count" >
DELETE FROM Student WHERE id='${param.r}';
</sql:update>
<c:if test="${count==1}">
 <c:out value="delete successful"/>
</c:if>
<c:if test="${count==0}">
 <c:out value="delete not successful"/>
</c:if>
</body>
</html>
