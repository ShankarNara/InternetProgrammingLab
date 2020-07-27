<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
    <body>
        <sql:setDataSource var="snapshot"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost/StudTable"
        user="root"
        password="thenextgenius"
        />
        <sql:query dataSource="${snapshot}" var="result">
            select * from students where pass like "${param.val}%";
        </sql:query>


        <center>
            <table border="1">
                <c:forEach var="row" items="${result.rows}">
                    <tr>
                        <td><c:out value="${row.pass}" /></td>
                    </tr>
                </c:forEach>
            </table>
        </center>
    </body>
</html>