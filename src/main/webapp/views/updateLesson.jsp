<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/08/2023
  Time: 5:40 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<label class="lblDesign">Name</label> <input type="text" placeholder="Name" id="nameId" value="${lesson.name}" > <br>
<label class="lblDesign">Time</label> <input type="number" placeholder="Time" id="timeId" value="${lesson.time}"> <br>
<label class="lblDesign">Price</label> <input type="number" placeholder="Price" id="priceId" value="${lesson.price}"> <br>
