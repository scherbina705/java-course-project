function validateInputFields() {
    $("form[id='send-post-form']").validate({
        rules: {
            title: {
                required: true,
                maxlength: 30
            },
            content: {
                required: true,
                maxlength: 300
            }
        },

        messages: {
            title: {
                required: "Please provide a title",
                maxlength: "Title can't be longer than 30 symbols",
            },
            content: {
                required: "Please provide a content",
                maxlength: "Title can't be longer than 300 symbols"
            },
        },

        submitHandler: function (form) {
            sendNewPost();
        }
    });
}

$(document).ready(function () {
    validateInputFields();
});

function sendNewPost() {
    var $form = $("#send-post-form");

    /* отправляем данные методом POST */
    var data = {
        authorLogin: $form.find("select[id='person']").val(),
        title: $form.find("input[id='title']").val(),
        content: $form.find("textarea[id='content']").val()
    };
    $.ajax({
        url: $form.attr('action'),
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data), //Stringified Json Object
        async: false,    //Cross-domain requests and dataType: "json" requests do not support synchronous operation
        cache: false,    //This will force requested pages not to be cached by the browser
        processData: false, //To avoid making query String instead of JSON
        success: function(){
            $form.find("input[id='title']").val("");
            $form.find("textarea[id='content']").val("");
            $("#send-post-form").append(function () {
                return "<h4 class='text-center' style='color:green'> <span class='glyphicon glyphicon-ok'></span> Your post has been sent</h4>"
            })
        }
    });
}






