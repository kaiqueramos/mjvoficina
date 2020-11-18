package br.com.mjvoficina.defeito.model;

/**
 * Classe referente a tabela DEFEITO
 * @author kaique
 *
 */
public class Defeito {
	private Integer idDefeito;
	private String nomeDefeito;
	
	public Integer getIdDefeito() {
		return idDefeito;
	}
	public void setIdDefeito(Integer idDefeito) {
		this.idDefeito = idDefeito;
	}
	public String getNomeDefeito() {
		return nomeDefeito;
	}
	public void setNomeDefeito(String nomeDefeito) {
		this.nomeDefeito = nomeDefeito;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDefeito == null) ? 0 : idDefeito.hashCode());
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
		Defeito other = (Defeito) obj;
		if (idDefeito == null) {
			if (other.idDefeito != null)
				return false;
		} else if (!idDefeito.equals(other.idDefeito))
			return false;
		return true;
	}
	
	
}
