package br.com.mjvoficina.registro.model;

import java.util.Date;

import br.com.mjvoficina.veiculo.enums.TipoVeiculo;

public class Registro {
	
	private Integer idRegistro;
	private Integer idVeiculo;
	private Integer idPeca;
	private Integer idDefeito;
	private Date dataRegistro;
	
	public Integer getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(Integer idRegistro) {
		this.idRegistro = idRegistro;
	}
	public Integer getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
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
	public Date getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
}
