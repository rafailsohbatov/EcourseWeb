<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/08/2023
  Time: 1:16 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <c:import url="/static/import.jsp"></c:import>
  <script type="text/javascript" src="js/lesson.js"></script>
</head>
<body>
<c:import url="/static/header.jsp"></c:import>
<div class="ui-layout-center">
  <table class="display" id="lessonTableId">
    <thead>
    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Time</th>
      <th>Price</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${lessonList}" var="ll" >
      <tr>
        <td>${ll.id}</td>
        <td>${ll.name}</td>
        <td>${ll.time}</td>
        <td>${ll.price}</td>

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

