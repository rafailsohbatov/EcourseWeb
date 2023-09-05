$(function (){
    new DataTable('#lessonTableId');

    $('#newBtnId').val('New Lesson')


    $('#newLessonDialogId').dialog({
        title:'New Lesson',
        modal:true,
        autoOpen:false,
        height : 400,
        width:400,
        buttons:{
            "Save": function (){
                addLesson();
                $(this).dialog('close');
            },
            "Clear":function () {
                $(this).dialog('close')
            }
        }
    })

    $('#newBtnId').click(function (){
        $('#newLessonDialogId').load('views/newLesson.jsp',function (){
            $(this).dialog('open');
        })
    })

    $('#updateLessonDialogId').dialog({
        title:'Update Lesson',
        modal:true,
        autoOpen:false,
        height : 400,
        width:400,
        buttons:{
            "Save": function (){
                $(this).dialog('close');
            },
            "Clear":function () {
                $(this).dialog('close')
            }
        }
    })

    $('#updateBtnId').click(function (){
        $('#updateLessonDialogId').load(
            'ls?action=getLessonById&lessonId='+$('#lessonId').val(),function (){
            $(this).dialog('open');
        })
    })
})

function addLesson(){
    let name = $('#nameId').val()
    let time = $('#timeId').val()
    let price = $('#priceId').val()

    let requestData = {
        name:name,
        time:time,
        price:price
    }

        $.ajax({
            url: 'ls?action=addLesson',
            data:requestData,
            type:'POST',
            dataType:'html',
            success:function (response){
                if(response == 'success'){
                    alert("Success! New Lesson has been successfully added")
                }else {
                    alert("Problem! New Lesson has not been added")
                }
            }
        })
}