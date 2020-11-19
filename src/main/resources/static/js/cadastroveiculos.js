let btn = $("#btn-submit");
let input = $("#inputText");
let checkbox = $("[name='peca']");
let checked = false;

/**
 * Ajax para validar campo
 */
function doAjax() {
    $.ajax({
        type: "get",
        url: `/cadastrarveiculos/getveiculo`,
        contentType: "application/json",
        data: { name: input.val().toLowerCase() },
        success: function (response) {
            btn.prop("disabled", true);
            btn.css("background-color", "");
            $("#feedback").addClass("invalid-feedback");
            input.removeClass("is-valid");
            input.addClass("is-invalid");
            $("#feedback").text("Você quer dizer " + response[0].nomeVeiculo + "? Se sim, esse veículo já existe na base de dados!");
            $("#feedback").removeClass("valid-feedback");
        },
        error: function (jqXhr, textStatus, errorMessage) {
            if (!checked) {
                return;
            }
            btn.prop("disabled", input.val().length < 1 ? true : false);
            btn.css("background-color", "#7B0B9A");
            $("#feedback").addClass("valid-feedback");
            input.addClass("is-valid");
            input.removeClass("is-invalid");
            $("#feedback").text("Esse veículo ainda não existe!");
            $("#feedback").removeClass("invalid-feedback");
        },
        complete: function (jqXhr, textStatus, errorMessage) {
            if (input.val() == "" || !checked) {
                if (!checked) {
                    btn.prop("disabled", true);
                    btn.css("background-color", "");
                    $("#feedback").addClass("invalid-feedback");
                    input.removeClass("is-valid");
                    input.addClass("is-invalid");
                    $("#feedback").text("Você precisa selecionar pelo menos 1 peça");
                    $("#feedback").removeClass("valid-feedback");
                    return;
                }
                btn.css("background-color", "");
                $("#feedback").removeClass("valid-feedback");
                input.removeClass("is-valid");
                input.removeClass("is-invalid");
                $("#feedback").text("");
                $("#feedback").removeClass("invalid-feedback");
            }
        },
    });
}

input.on("input", doAjax);

$(input).on("input", function () {
    checked = false;
    for (let i = 0; i < checkbox.length; i++) {
        if (checkbox[i].checked) {
            checked = true;
        }
    }
});
