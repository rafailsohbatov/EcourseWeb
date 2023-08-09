<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08/08/2023
  Time: 2:00 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function (){
        $('#dobId').datepicker({
            changeMonth:true,
            changeYear:true
        });
    });
</script>
<label class="lblDesign">Name</label> <input type="text" placeholder="Name" id="nameId"> <br>
<label class="lblDesign">Surname</label> <input type="text" placeholder="Surname" id="surnameId"> <br>
<label class="lblDesign">Date of Birth</label> <input type="text" placeholder="Date of Birth" id="dobId"> <br>
<label class="lblDesign">Address</label> <input type="text" placeholder="Address" id="addressId"> <br>
<label class="lblDesign">Phone</label> <input type="text" placeholder="Phone" id="phoneId"> <br>
