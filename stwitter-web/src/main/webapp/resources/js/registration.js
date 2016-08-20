function validateInputFields() {
    $("form[id='registration-form']").validate({
        rules: {
            firstName: "required",
            lastName: "required",
            email: {
                required: true,
                email: true
            },
            pwd: {
                required: true,
                minlength: 5
            },
            nickName: {
                required: true,
                minlength: 5,
                maxlength: 15,
                notnumbers: true
            },
            date: "required"
        },

        messages: {
            firstName: "Please enter your firs tname",
            lastName: "Please enter your last name",
            nickName: {
                required: "Please enter your login/nickname",
                minlength: "Your login/nickname must be from 5 to 15 characters long",
                notnumbers: "Shouldn't be numbers"
            },
            date: "Please enter your birthdate",
            pwd: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
            email: "Please! enter a valid email address"

        },

        submitHandler: function (form) {
            sendRegisterUserPostRequest();
        }
    });
}

$(document).ready(function () {
    $.validator.addMethod("notnumbers", function (value, element) {
        var response = null;
        $.get(
            "/registration/isLoginAvailable",
            {
                login: "12345"
            },
            function(data){
                response = data;
            }
        );

        return response == true;
    });

    var date_input = $('input[name="date"]'); //our date input has the name "date"
    var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
    var options = {
        format: 'yyyy-mm-dd',
        container: container,
        todayHighlight: true,
        autoclose: true,
    };
    date_input.datepicker(options);
    validateInputFields();
});

function sendRegisterUserPostRequest() {
    var $form = $("#registration-form");
    var hobbies = [];

    $.each($("input[type='checkbox']:checked"), function () {
        hobbies.push(parseInt($(this).val()));
    });
    /* отправляем данные методом POST */
    var data = {
        login: $form.find("input[id='nickName']").val(),
        email: $form.find("input[id='email']").val(),
        firstName: $form.find("input[id='firstName']").val(),
        lastName: $form.find("input[id='lastName']").val(),
        password: $form.find("input[id='pwd']").val(),
        birthday: new Date($form.find("input[id='date']").val()).toISOString(),
        hobbiesId: hobbies
    };
    $.ajax({
        url: $form.attr('action'),
        type: "POST",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data), //Stringified Json Object
        async: false,    //Cross-domain requests and dataType: "jsonp" requests do not support synchronous operation
        cache: false,    //This will force requested pages not to be cached by the browser
        processData: false, //To avoid making query String instead of JSON
        success: function (resposeJsonObject) {
            alert(resposeJsonObject);
        }
    });
}




//$.ajax({
//    type: "GET",
//    url: "/registration/isLoginAvailable",
//    data: {login: "123456"},
//    async: false
//});
