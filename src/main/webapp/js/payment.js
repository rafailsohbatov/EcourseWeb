
$(function(){
    new DataTable('#paymentTableId');

    $('#newBtnId').val('New Payment');

    $('#newPaymentDialogId').dialog({
        title:'New Payment',
        modal:true,
        autoOpen:false,
        height:400,
        width:400,
        buttons: {
            "Save": function (){
                addPayment();
                $(this).dialog('close');
            },
            "Clear": function (){
                $(this).dialog('close');
            }
        }
    })
    $('#newBtnId').click(function () {
        $('#newPaymentDialogId').load('ps?action=addPayment',function () {
            $('#newPaymentDialogId').dialog('open');
        })
    })

})

function addPayment() {

}