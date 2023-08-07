<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.ecourseweb.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07/08/2023
  Time: 2:03 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Student> studentList = (List<Student>) request.getAttribute("studentList");%>
<!DOCTYPE html>
<html>
<head>
    <c:import url="/static/import.jsp"></c:import>
</head>
<body>
<c:import url="/static/info.jsp"></c:import>
<c:import url="/static/header.jsp"></c:import>
<c:import url="/static/menu.jsp"></c:import>
<div class="ui-layout-center">
        <table border="1" width="100%">
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
            <% for (Student student : studentList) { %>
            <tr>
                <td><%= student.getId()%>
                </td>
                <td><%= student.getName()%>
                </td>
                <td><%= student.getSurname()%>
                </td>
                <td><%= student.getAddress()%>
                </td>
                <td><%= student.getPhone()%>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
</div>
<c:import url="/static/footer.jsp"></c:import>
</body>
</html>


