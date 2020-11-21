package br.com.mjvoficina.possiveisPecasVeiculos.model;

/**
 * Classe referente a tabela POSSIVEIS_PECAS_VEICULO
 * @author kaique
 *
 */
public class PossivelPecaVeiculo {
	private Integer idPossivelPecaVeiculo;
	private Integer idVeiculo;
	private Integer idPossivelDefeitoPeca;
	
	public Integer getIdPossivelPecaVeiculo() {
		return idPossivelPecaVeiculo;
	}
	public void setIdPossivelPecaVeiculo(Integer idPossivelPecaVeiculo) {
		this.idPossivelPecaVeiculo = idPossivelPecaVeiculo;
	}
	public Integer getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public Integer getIdPossivelDefeitoPeca() {
		return idPossivelDefeitoPeca;
	}
	public void setIdPossivelDefeitoPeca(Integer idPossivelDefeitoPeca) {
		this.idPossivelDefeitoPeca = idPossivelDefeitoPeca;
	}
	
	
}
