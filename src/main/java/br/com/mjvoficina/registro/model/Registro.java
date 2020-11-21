package br.com.mjvoficina.registro.model;

import java.util.Date;

/**
 * Classe referente a tabela REGISTROS, apenas com IDs. Usa-se a classe MappedRegistros
 * para retornar um objeto mapeados com seus sub-objetos referentes
 * @author kaique
 *
 */
public class Registro {
	
	private Integer idRegistro;
	private Integer idPeca;
	private Integer idDefeito;
	private Integer idVeiculo;
	private Date dataRegistro;
	
	public Integer getIdPeca() {
		return idPeca;
	}
	public void setIdPeca(Integer idPeca) {
		this.idPeca = idPeca;
	}
	public Integer getIdDefeito() {
		return idDefeito;
	}
	public void setIdDefeito(Integer idDefeito) {
		this.idDefeito = idDefeito;
	}
	public Integer getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public Integer getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(Integer idRegistro) {
		this.idRegistro = idRegistro;
	}
	public Date getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
}
