package br.com.mjvoficina.possiveisDefeitosPecas.model;

/**
 * Classe referente a tabela POSSIVEIS_DEFEITOS_PECA
 * @author kaique
 *
 */
public class PossivelDefeitoPeca {
	private Integer idPossivelDefeitoPeca;
	private Integer idDefeito;
	private Integer idPeca;
	
	public Integer getIdPossivelDefeitoPeca() {
		return idPossivelDefeitoPeca;
	}
	public void setIdPossivelDefeitoPeca(Integer idPossivelDefeitoPeca) {
		this.idPossivelDefeitoPeca = idPossivelDefeitoPeca;
	}
	public Integer getIdDefeito() {
		return idDefeito;
	}
	public void setIdDefeito(Integer idDefeito) {
		this.idDefeito = idDefeito;
	}
	public Integer getIdPeca() {
		return idPeca;
	}
	public void setIdPeca(Integer idPeca) {
		this.idPeca = idPeca;
	}
	
}
