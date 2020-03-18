
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP List Users Records</title>
</head>
<body>
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/trail"
        user="root" password="ssn"
    />
     
    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM students;
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="4">
            <caption><h2>List of students</h2></caption>
            <tr>
                <th>id</th>
                <th>name</th>
                <th>age</th>
                <th>address</th>
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.age}" /></td>
                    <td><c:out value="${user.address}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
