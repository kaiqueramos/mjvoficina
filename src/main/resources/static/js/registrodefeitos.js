$("#veiculos").change(function () {
    $.ajax({
        type: "get",
        url: "/registrodefeitos/getdefeitospecas",
        data: `name=${$("#veiculos option:selected").val()}`,
        contentType: "application/json",
        success: function (response) {
            console.log("Foi");
            console.log(response);
        },
        error: function (response) {
            console.log("Não foi");
        },
        complete: function (response) {
            console.log("Acabou");
        },
    });
    console.log($("#veiculos option:selected").text());
});
