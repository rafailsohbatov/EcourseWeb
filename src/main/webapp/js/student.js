$(function () {
    new DataTable('#studentTableId');

    $('#newBtnId').val('New Student')

    $('#newStudentDialogId').dialog({
        title: 'New Student',
        modal: true,
        autoOpen: false,
        height: 400,
        width: 400,
        buttons: {
            "Save": function () {
                addStudent();
                $(this).dialog('close');
            },
            "Close": function () {
                $(this).dialog('close');
            }
        }
    });

    $('#newBtnId').click(function () {
        $('#newStudentDialogId').load("views/newStudent.jsp", function () {
            $(this).dialog('open');
        })

    })
})

function addStudent() {
    let name = $('#nameId').val();
    let surname = $('#surnameId').val();
    let dob = $('#dobId').val();
    let address = $('#addressId').val();
    let phone = $('#phoneId').val();

    let request = {
        name: name,
        surname: surname,
        dob: dob,
        address: address,
        phone: phone
    };
    $.ajax({
        url: 'ss?action=addStudent',
        type: 'POST',
        data: request,
        dataType: 'text',
        success: function (response) {
            if (response == 'success') {
                alert("Student has been successfully added");
                getStudentList();
            } else {
                alert("Problem ! Student has not been  added");
            }
        }
    })
}

function getStudentList() {
    $.ajax({
        url: 'ss?action=getStudentData',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        }
    })
}

