let btn = $("#btn-submit");
let input = $("#inputText");
let checkbox = $("[name='defeito']");
let checked = false;

/**
 * Ajax para validar campo
 */
function doAjax() {
    $.ajax({
        type: "get",
        url: `/cadastrarpecas/getpeca`,
        contentType: "application/json",
        data: { name: input.val().toLowerCase() },
        success: function (response) {
            btn.prop("disabled", true);
            btn.css("background-color", "");
            $("#feedback").addClass("invalid-feedback");
            input.removeClass("is-valid");
            input.addClass("is-invalid");
            $("#feedback").text("Esa peça já existe na base de dados!");
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
            $("#feedback").text("Essa peça ainda não existe!");
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
                    $("#feedback").text("Você precisa selecionar pelo menos 1 defeito");
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

checkbox.on("change", function () {
    if (checkbox.is(":checked")) {
        checked = true;
        doAjax();
    } else {
        checked = false;
        doAjax();
    }
});

$(input).on("input", function () {
    for (let i = 0; i < checkbox.length; i++) {
        if (checkbox[i].checked) {
            checked = true;
        }
    }
});

$("#checkAll").change(function () {
    $("input:checkbox").prop("checked", $(this).prop("checked"));
    if (checkbox.is(":checked")) {
        checked = true;
        doAjax();
    } else {
        checked = false;
        doAjax();
    }
});
