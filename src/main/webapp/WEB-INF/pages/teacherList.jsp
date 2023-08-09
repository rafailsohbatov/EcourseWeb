<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08/08/2023
  Time: 5:50 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <c:import url="/static/import.jsp"></c:import>
    <script src="js/teacher.js"></script>
</head>
<body>
<c:import url="/static/header.jsp"></c:import>
<div class="ui-layout-center">
<table class="display" id="teacherTableId" >
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Date of Birth</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Work Experience</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${teacherList}" var="teacherList">
    <tr>
        <td>${teacherList.id}</td>
        <td>${teacherList.name}</td>
        <td>${teacherList.surname}</td>
        <td>${teacherList.dob}</td>
        <td>${teacherList.address}</td>
        <td>${teacherList.phone}</td>
        <td>${teacherList.work_experience}</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<c:import url="/static/menu.jsp"></c:import>
<c:import url="/static/info.jsp"></c:import>
<c:import url="/static/footer.jsp"></c:import>
<div id="newTeacherDialogId">

</div>
</body>
</html>
