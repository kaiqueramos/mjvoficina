let btn = $("#btn-submit");
let input = $("#inputText");

/**
 * Ajax para validar campo
 */
input.on("input", function () {
    $.ajax({
        type: "get",
        url: `/cadastrardefeitos/getdefeito`,
        contentType: "application/json",
        data: { name: input.val().toLowerCase() },
        success: function (response) {
            btn.prop("disabled", true);
            btn.css("background-color", "");
            $("#feedback").addClass("invalid-feedback");
            input.removeClass("is-valid");
            input.addClass("is-invalid");
            $("#feedback").text("Esse defeito já existe na base de dados!");
            $("#feedback").removeClass("valid-feedback");
        },
        error: function (jqXhr, textStatus, errorMessage) {
            btn.prop("disabled", input.val().length < 1 ? true : false);
            btn.css("background-color", "#7B0B9A");
            $("#feedback").addClass("valid-feedback");
            input.addClass("is-valid");
            input.removeClass("is-invalid");
            $("#feedback").text("Esse defeito ainda não existe!");
            $("#feedback").removeClass("invalid-feedback");
        },
        complete: function (jqXhr, textStatus, errorMessage) {
            if (input.val() == "") {
                btn.css("background-color", "");
                $("#feedback").removeClass("valid-feedback");
                input.removeClass("is-valid");
                input.removeClass("is-invalid");
                $("#feedback").text("");
                $("#feedback").removeClass("invalid-feedback");
            }
        },
    });
});
