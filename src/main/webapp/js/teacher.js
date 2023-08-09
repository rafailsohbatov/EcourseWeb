$(function () {
    new DataTable('#teacherTableId');

    $('#newBtnId').val('New Teacher');

    $('#newTeacherDialogId').dialog({
        title: 'New Teacher',
        modal: true,
        autoOpen: false,
        height: 400,
        width: 400,
        buttons: {
            "Save": function () {
                addTeacher();
                $(this).dialog('close');
            },
            "Clear": function () {
                $(this).dialog('close');
            }
        }
    })

    $('#newBtnId').click(function (){
        $("#newTeacherDialogId").load("views/newTeacher.jsp",function(){
            $('#newTeacherDialogId').dialog('open');
        })
    })
})

function addTeacher(){
    let name = $('#nameId').val();
    let surname = $('#surnameId').val();
    let dob = $('#dobId').val();
    let address = $('#addressId').val();
    let phone = $('#phoneId').val();
    let workExperience = $('#workExperienceId').val();

    let request = {
        name: name,
        surname: surname,
        dob: dob,
        address: address,
        phone: phone,
        workExperience:workExperience
    };
    $.ajax({
        url: 'ts?action=addTeacher',
        type: 'POST',
        data: request,
        dataType: 'text',
        success: function (response) {
            if (response == 'success') {
                alert("Teacher has been successfully added");
            } else {
                alert("Problem ! Student has not been  added");
            }
        }
})
}