let checked = false;
let btn = $("#btn-submit");
let checkbox = $("[name='registros']");

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
                        <input name="registros" value="${element.idPossivelDefeitoPeca}" type="checkbox" class="custom-control-input" id="${element.idPossivelDefeitoPeca}">
                        <label class="custom-control-label" for="${element.idPossivelDefeitoPeca}"></label>
                    </div>
                    </td>
                    <td>${element.defeito}</td>
                    <td>${element.peca}</td>
                </tr>`
                );
                console.log(element.peca);
            });
        },
        error: function (response) {
            $("#tabela").html("");
        },
        complete: function (response) {
            console.log("Acabou");
        },
    });
    console.log($("#veiculos option:selected").text());
});

$(document).ready(function () {
    const now = new Date();

    // Formata a data conforme dd/mm/aaaa hh:ii:ss
    const data = "Acesso: " + zeroFill(now.getUTCDate()) + "/" + zeroFill(now.getMonth() + 1) + "/" + now.getFullYear();
    const hora = "Horário: " + zeroFill(now.getHours()) + ":" + zeroFill(now.getMinutes()) + ":" + zeroFill(now.getSeconds());
    // Exibe na tela usando a div#data-hora
    document.getElementById("data").innerHTML = data;
    document.getElementById("hora").innerHTML = hora;
});

const zeroFill = (n) => {
    return ("0" + n).slice(-2);
};

// Cria intervalo
const interval = setInterval(() => {
    // Pega o horário atual
    const now = new Date();

    // Formata a data conforme dd/mm/aaaa hh:ii:ss
    const data = "Acesso: " + zeroFill(now.getUTCDate()) + "/" + zeroFill(now.getMonth() + 1) + "/" + now.getFullYear();
    const hora = "Horário: " + zeroFill(now.getHours()) + ":" + zeroFill(now.getMinutes()) + ":" + zeroFill(now.getSeconds());
    // Exibe na tela usando a div#data-hora
    document.getElementById("data").innerHTML = data;
    document.getElementById("hora").innerHTML = hora;
}, 1000);
