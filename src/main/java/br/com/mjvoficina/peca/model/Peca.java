package br.com.mjvoficina.peca.model;

import java.util.ArrayList;
import java.util.List;

import br.com.mjvoficina.defeito.model.Defeito;

/**
 * Classe referente a tabela PECA
 * @author kaique
 *
 */
public class Peca {
	private Integer idPeca;
	private String nomePeca;
	private List<Defeito> listDefeitos = new ArrayList<>();
	
	
	public Integer getIdPeca() {
		return idPeca;
	}
	public void setIdPeca(Integer idPeca) {
		this.idPeca = idPeca;
	}
	public String getNomePeca() {
		return nomePeca;
	}
	public void setNomePeca(String nomePeca) {
		this.nomePeca = nomePeca;
	}
	public List<Defeito> getListDefeitos() {
		return listDefeitos;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPeca == null) ? 0 : idPeca.hashCode());
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
		Peca other = (Peca) obj;
		if (idPeca == null) {
			if (other.idPeca != null)
				return false;
		} else if (!idPeca.equals(other.idPeca))
			return false;
		return true;
	}
	
	
	
}
