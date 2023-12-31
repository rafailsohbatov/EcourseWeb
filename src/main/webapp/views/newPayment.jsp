<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 09/08/2023
  Time: 3:16 pm
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">
    $(function (){
        $('#studentCmbId').change(function () {
            getLessonListByStudentId($(this).val());
        })

        $('#lessonCmbId').change(function () {
            let studentId = $('#studentCmbId').val();
            getTeacherListByLessonIdAndStudentId($(this).val(), studentId);
        })
    })
</script>
<label class="lblDesign">Student</label>
<select style="width:  150px" id="studentCmbId" class="cmbDesign">
    <option value="0">Select Student</option>
    <c:forEach items="${studentList}" var="sl">
        <option value="${sl.id}">"${sl.name}" "${sl.surname}"</option>
    </c:forEach>
</select> <br>
<label class="lblDesign">Lesson</label>
<select style="width:  150px" id="lessonCmbId" class="cmbDesign">
    <option value="0">Select Lesson</option>
    <c:forEach items="${lessonList}" var="ll">
        <option value="${ll.id}">"${ll.name}" "${ll.price}"</option>
    </c:forEach>
</select> <br>
<label class="lblDesign">Teacher</label>
<select style="width:  150px" id="teacherCmbId" class="cmbDesign">
    <option value="0">Select Teacher</option>
    <c:forEach items="${teacherList}" var="tl">
        <option value="${tl.id}">"${tl.name}" "${tl.surname}"</option>
    </c:forEach>
</select> <br>
<label class="lblDesign">Amount</label>
<input type="text" id="amountId" placeholder="Amount" />