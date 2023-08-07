<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--  Created by IntelliJ IDEA.
  User: Admin
  Date: 07/08/2023
  Time: 2:03 pm
  To change this template use File | Settings | File Templates.
--%>
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
                <th>Student Full Name </th>
                <th>Teacher Full Name </th>
                <th>Lesson Name</th>
                <th>Lesson Time</th>
                <th>Lesson Price</th>
                <th>Amount</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${paymentList}" var="paymentList" >
            <tr>
                <td>${paymentList.id}</td>
                <td>"${paymentList.studentTeacherLesson.student.name} ${paymentList.studentTeacherLesson.student.surname}"
                </td>
                <td>${paymentList.studentTeacherLesson.teacherLesson.teacher.name} ${paymentList.studentTeacherLesson.teacherLesson.teacher.surname}
                </td>
                <td>${paymentList.studentTeacherLesson.teacherLesson.lesson.name}
                </td>
                <td>${paymentList.studentTeacherLesson.teacherLesson.lesson.time}
                </td>
                <td>${paymentList.studentTeacherLesson.teacherLesson.lesson.price}
                </td>
                <td>${paymentList.amount}
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
</div>
<c:import url="/static/footer.jsp"></c:import>
</body>
</html>

