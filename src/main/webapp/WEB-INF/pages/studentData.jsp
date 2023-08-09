<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/08/2023
  Time: 11:52 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
    <c:forEach items="${studentList}" var="sl">
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
<script type="text/javascript">
    $(function () {
        new DataTable('#studentTableId');
    })
</script>
