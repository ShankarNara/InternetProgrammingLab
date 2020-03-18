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
INSERT INTO Student VALUES (?,?);
            <sql:param value="${param.r}" />
            <sql:param value="${param.n}" />
</sql:update>
<c:if test="${count==1}">
 <c:out value="update successful"/>
</c:if>
<c:if test="${count==0}">
 <c:out value="update not successful"/>
</c:if>
</body>
</html>
