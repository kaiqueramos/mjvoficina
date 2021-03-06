package br.com.mjvoficina.veiculo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.mjvoficina.peca.model.Peca;

/**
 * Classe referente a tabela VEICULO
 * @author kaique
 *
 */
public class Veiculo {
	private Integer idVeiculo;
	private String tipoVeiculo;
	private Date dataInclusao;
	private List<Peca> pecas = new ArrayList<>();
	
	
	public Integer getIdVeiculo() {
		return idVeiculo;
	}
	public void setIdVeiculo(Integer idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	public String getTipoVeiculo() {
		return tipoVeiculo;
	}
	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}
	public Date getDataInclusao() {
		return dataInclusao;
	}
	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
	public List<Peca> getPecas() {
		return pecas;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVeiculo == null) ? 0 : idVeiculo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (idVeiculo == null) {
			if (other.idVeiculo != null)
				return false;
		} else if (!idVeiculo.equals(other.idVeiculo))
			return false;
		return true;
	}
	
}
