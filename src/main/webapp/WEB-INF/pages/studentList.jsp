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
<html>
<head>
    <title>Ecourse</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
    <jsp:include page="/static/header.jsp"></jsp:include>
    <jsp:include page="/static/menu.jsp"></jsp:include>
    <div id="content">

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
    <jsp:include page="/static/footer.jsp"></jsp:include>
</div>
</body>
</html>

