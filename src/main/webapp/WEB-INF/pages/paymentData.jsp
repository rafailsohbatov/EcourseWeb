<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/08/2023
  Time: 6:43 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
  $(function () {
    new DataTable('#paymentTableId');
  })
</script>
<table class="display" id="paymentTableId">
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
