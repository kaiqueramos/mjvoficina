package br.com.mjvoficina.registro.model;

import java.util.Date;

import br.com.mjvoficina.defeito.model.Defeito;
import br.com.mjvoficina.peca.model.Peca;
import br.com.mjvoficina.veiculo.model.Veiculo;

/**
 * Classe para mapear um objeto registros com apenas IDs para um objeto com
 * outros objetos aninhados, referentes aos IDs
 * @author kaique
 *
 */
public class MappedRegistro {
	private Integer idRegistro;
	private Veiculo veiculo;
	private Peca peca;
	private Defeito defeito;
	private Date dataRegistro;
	
	public Integer getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(Integer idRegistro) {
		this.idRegistro = idRegistro;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Peca getPeca() {
		return peca;
	}
	public void setPeca(Peca peca) {
		this.peca = peca;
	}
	public Defeito getDefeito() {
		return defeito;
	}
	public void setDefeito(Defeito defeito) {
		this.defeito = defeito;
	}
	public Date getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	
}
