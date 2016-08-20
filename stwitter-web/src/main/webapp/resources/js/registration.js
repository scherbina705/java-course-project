$(document).ready(function () {
    var date_input = $('input[name="date"]'); //our date input has the name "date"
    var container = $('.bootstrap-iso form').length > 0 ? $('.bootstrap-iso form').parent() : "body";
    var options = {
        format: 'yyyy-mm-dd',
        container: container,
        todayHighlight: true,
        autoclose: true,
    };
    date_input.datepicker(options);
});

$("#registration-form").submit(function (event) {
    /* switch off default form sending */
    event.preventDefault();

    /* собираем данные с элементов страницы: */
    var $form = $(this);
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
    /* результат помещаем в div */
    posting.done(function (data) {
        var content = $(data).find('#content');

        $("#result").empty().append(content);

    });

});
