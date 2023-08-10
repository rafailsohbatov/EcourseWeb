$(function () {
    new DataTable('#paymentTableId');

    $('#newBtnId').val('New Payment');

    $('#newPaymentDialogId').dialog({
        title: 'New Payment',
        modal: true,
        autoOpen: false,
        height: 400,
        width: 400,
        buttons: {
            "Save": function () {
                addPayment();
                $(this).dialog('close');
                getPaymentList();
            },
            "Clear": function () {
                $(this).dialog('close');
            }
        }
    })
    $('#newBtnId').click(function () {
        $('#newPaymentDialogId').load('ps?action=newPayment', function () {
            $('#newPaymentDialogId').dialog('open');
        })
    })


})

function getLessonListByStudentId(studentId) {
    $.ajax({
        url: 'ls?action=getLessonListByStudentId',
        type: 'GET',
        data: 'studentId=' + studentId,
        dataType: 'html',
        success: function (response) {
            $('#lessonCmbId').html(response);
        }
    })
}

function getTeacherListByLessonIdAndStudentId(lessonId, studentId) {
    $.ajax({
        url: 'ts?action=getTeacherListByLessonIdAndStudentId',
        type: 'GET',
        data: 'studentId=' + studentId + '&lessonId=' + lessonId,
        dataType: 'html',
        success: function (response) {
            $('#teacherCmbId').html(response);
        }
    })
};

function addPayment() {

    let requestData = {
        studentId: $('#studentCmbId').val(),
        lessonId: $('#lessonCmbId').val(),
        teacherId: $('#teacherCmbId').val(),
        amount: $('#amountId').val(),
    }

    $.ajax({
        url: 'ps?action=addPayment',
        type: 'POST',
        data: requestData,
        dataType: 'html',
        success: function (response) {
            if (response == 'success') {
                alert('Success ! Payment has been added')
            } else {
                alert('Problem ! Payment has not been added')
            }
        }
    })
}

function getPaymentList() {
    $.ajax({
        url: 'ps?action=getPaymentData',
        type: 'GET',
        dataType: 'html',
        success: function (response) {
            $('.ui-layout-center').html(response);
        }
    })
}