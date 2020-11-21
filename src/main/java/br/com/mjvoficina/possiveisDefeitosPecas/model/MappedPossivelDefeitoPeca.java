package br.com.mjvoficina.possiveisDefeitosPecas.model;

/**
 * Classe referente aos registros da tabela POSSIVEIS_DEFEITOS_PECA
 * @author kaique
 *
 */
public class MappedPossivelDefeitoPeca {
	
	private Integer idPossivelDefeitoPeca;
	private String defeito;
	private String peca;
	
	public Integer getIdPossivelDefeitoPeca() {
		return idPossivelDefeitoPeca;
	}
	public void setIdPossivelDefeitoPeca(Integer idPossivelDefeitoPeca) {
		this.idPossivelDefeitoPeca = idPossivelDefeitoPeca;
	}
	public String getDefeito() {
		return defeito;
	}
	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}
	public String getPeca() {
		return peca;
	}
	public void setPeca(String peca) {
		this.peca = peca;
	}
		
}
