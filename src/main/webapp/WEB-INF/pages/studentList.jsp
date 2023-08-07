<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07/08/2023
  Time: 2:03 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <c:import url="/static/import.jsp"></c:import>
    <script type="text/javascript" src="js/student.js"></script>
</head>
<body>
<c:import url="/static/header.jsp"></c:import>
<div class="ui-layout-center">
        <table class="display" id="studentTableId">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Address</th>
                <th>Phone</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${studentList}" var="sl" >
            <tr>
                <td>${sl.id}</td>
                <td>${sl.name}</td>
                <td>${sl.surname}</td>
                <td>${sl.address}</td>
                <td>${sl.phone}</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
</div>
<c:import url="/static/info.jsp"></c:import>
<c:import url="/static/menu.jsp"></c:import>
<c:import url="/static/footer.jsp"></c:import>
</body>
</html>


