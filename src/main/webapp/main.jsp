<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07.08.2023
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Ecourse</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
  <div id="header">
    <h1 style="margin-bottom:0;">E-course</h1>
  </div>
  <div id="menu">
    <a href="ss?action=getStudentList" ><input type="button" value="Student Data" class="btnDesign"></a>
    <a href="ts?action=getTeacherList" ><input type="button" value="Teacher Data" class="btnDesign"></a>
  </div>
  <div id="content"></div>
  <div id="footer">

  </div> </div>
</body>
</html>

