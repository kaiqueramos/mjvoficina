$("#veiculos").change(function () {
    $.ajax({
        type: "get",
        url: "/registrodefeitos/getdefeitospecas",
        data: `name=${$("#veiculos option:selected").val()}`,
        contentType: "application/json",
        success: function (response) {
            $("#tabela").html("");
            response.forEach((element) => {
                $("#tabela").append(
                    `<tr>
                    <td>
                    <div class="custom-control">
                        <input name="registros" value="${element.idRegistro}" type="checkbox" class="custom-control-input" id="${element.idRegistro}">
                        <label class="custom-control-label" for="${element.idRegistro}"></label>
                    </div>
                    </td>
                    <td>${element.defeito.nomeDefeito}</td>
                    <td>${element.peca.nomePeca}</td>
                </tr>`
                );
                console.log(element.peca.nomePeca);
            });
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
