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
        person: $form.find("select[id='person']").val(),
        title: $form.find("input[id='title']").val(),
        content: $form.find("textarea[id='content']").val(),
        placeTime: new Date().toISOString()
    };
    $.ajax({
        url: $form.attr('action'),
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data), //Stringified Json Object
        async: false,    //Cross-domain requests and dataType: "json" requests do not support synchronous operation
        cache: false,    //This will force requested pages not to be cached by the browser
        processData: false, //To avoid making query String instead of JSON
    });
}






