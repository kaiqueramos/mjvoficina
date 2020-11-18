package br.com.mjvoficina.peca.service;

import java.util.List;

import br.com.mjvoficina.defeito.model.Defeito;
import br.com.mjvoficina.peca.model.Peca;

public interface PecaService {
	
	/**
	 * Retorna uma lista de peças
	 * @return
	 */
	List<Peca> getAll();
	
	/**
	 * Retorna uma peca buscando pelo ID
	 * @param id
	 * @return
	 */
	Peca getById(Integer id);
	
	/**
	 * Retorna uma lista de Pecas buscando pelo NOME
	 * @param name
	 * @return
	 */
	List<Peca> getByName(String name);
	
	/**
	 * Retorna um Peca buscando pelo NOME
	 * @return
	 */
	Peca getOneByName(String name);
	
	/**
	 * Salva um novo Peca
	 * @param Peca
	 */
	Integer save(Peca peca);
	
	/**
	 * Insere uma lista de defeitos na tabela PECA_DEFEITOS
	 * @param list
	 */
	void insertDefeitos(List<Defeito> list, Integer idPeca);
}
