function doAjax() {
    $.ajax({
        type: "get",
        url: "/registrodefeitos/exibir/get",
        data: {
            name: $("#veiculos option:selected").val(),
            dataInicio: $("#dataInicio").val(),
            dataFim: $("#dataFim").val(),
        },
        contentType: "application/json",
        success: function (response) {
            $("#tabela").html("");
            response.forEach((element) => {
                $("#tabela").append(
                    `<tr>
                    <td>Cliente</td>
                    <td>${element.dataRegistro}</td>
                    <td>${element.veiculo.tipoVeiculo}</td>
                    <td>
                        <a type="button" data-toggle="modal" data-target="#modalRegistro${element.idRegistro}">
                            Ler mais
                        </a>
                        
                        <!-- Modal -->
                        <div class="modal fade" id="modalRegistro${element.idRegistro}" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Registro nº ${element.idRegistro} - Cliente: #nomeDoCliente </h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                                </div>
                                <div class="modal-body">
                                <h4>Data de criação:</h4>
                                <p>${element.dataRegistro}</p>
                                <h4>Veículo:</h4>
                                <p>${element.veiculo.tipoVeiculo}</p>
                                <h4>Peça:</h4>
                                <p>${element.peca.nomePeca}</p>
                                <h4>Defeito:</h4>
                                <p>${element.defeito.nomeDefeito}</p>
                                </div>
                                <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                                </div>
                            </div>
                            </div>
                        </div>
                    </td>
                    </tr>
                
                `
                );
                console.log(element.peca.nomePeca);
            });
            console.log(response);
        },
        error: function (response) {
            $("#tabela").html("");
            console.log(response);
        },
        complete: function (response) {
            console.log("Acabou");
        },
    });
    console.log($("#veiculos option:selected").text());
}

$(document).ready(doAjax);
$("#veiculos").change(doAjax);
$("#btn-submit").on("click", doAjax);
