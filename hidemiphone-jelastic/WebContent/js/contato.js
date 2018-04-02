$(function () {

    $('#faleConosco').validator();

    $('#faleConosco').on('submit', function (e) {
        if (!e.isDefaultPrevented()) {
            var url = ""; // COLOCAR ARQUIVO DE ENVIO, EX: contato.php

            $.ajax({
                type: "POST",
                url: url,
                data: $(this).serialize(),
                success: function (data)
                {
                    var messageAlert = 'alert-' + data.type;
                    var messageText = data.message;

                    var alertBox = '<div class="alert ' + messageAlert + ' alert-dismissable"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>' + messageText + '</div>';
                    if (messageAlert && messageText) {
                        $('#faleConosco').find('.messages').html(alertBox);
                        $('#faleConosco')[0].reset();
                    }
                }
            });
            return false;
        }
    })
});