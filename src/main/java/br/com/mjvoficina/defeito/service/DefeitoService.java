package br.com.mjvoficina.defeito.service;

import java.util.List;

import br.com.mjvoficina.defeito.model.Defeito;

/**
 * Interface service referente a entidade DEFEITO
 * @author kaique
 *
 */
public interface DefeitoService {
	
	/**
	 * Retorna uma lista de defeitos
	 * @return
	 */
	List<Defeito> getAll();
	
	/**
	 * Retorna um defeito buscando pelo ID
	 * @param id
	 * @return
	 */
	Defeito getById(Integer id);
	
	/**
	 * Retorna uma lista de defeitos buscando pelo NOME
	 * @param name
	 * @return
	 */
	List<Defeito> getByName(String name);
	
	/**
	 * Retorna um defeito buscando pelo NOME
	 * @return
	 */
	Defeito getOneByName(String name);
	
	/**
	 * Salva um novo defeito
	 * @param defeito
	 */
	void save(Defeito defeito);
}
