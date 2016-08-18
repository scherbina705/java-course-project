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
})

function SendPost() {
    //отправляю POST запрос и получаю ответ

    $$a({
        type: 'post',//тип запроса: get,post либо head
        url: 'addUser',//url адрес файла обработчика
        data: {'z': '1'},//параметры запроса
        response: 'text',//тип возвращаемого ответа text либо xml
        success: function (data) {//возвращаемый результат от сервера
            $$('result', $$('result').innerHTML + '<br />' + data);
        }
    });
}

/* прикрепить событие submit к форме */
$("#registration-form").submit(function (event) {
    /* отключение стандартной отправки формы */
    event.preventDefault();
    /* собираем данные с элементов страницы: */
    var $form = $(this),
        firstName = $form.find("input[id='firstName']").val(),
        lastName = $form.find("input[id='lastName']").val(),
        login = $form.find("input[id='nickName']").val(),
        email = $form.find("input[id='email']").val(),
        password = $form.find("input[id='pwd']").val(),
        birthday = new Date($form.find("input[id='date']").val()).toISOString(),
        url = $form.attr('action');
    /* отправляем данные методом POST */
    var posting = $.post(url, {
        login: login,
        email: email,
        firstName: firstName,
        lastName: lastName,
        password: password,
        birthday: birthday
    });
    /* результат помещаем в div */
    posting.done(function (data) {

        var content = $(data).find('#content');

        $("#result").empty().append(content);

    });

});
