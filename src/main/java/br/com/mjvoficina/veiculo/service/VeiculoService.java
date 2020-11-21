package br.com.mjvoficina.veiculo.service;

import java.util.List;

import br.com.mjvoficina.possiveisDefeitosPecas.model.PossivelDefeitoPeca;
import br.com.mjvoficina.veiculo.model.Veiculo;

/**
 * Interface Service referente a entidade VEICULO
 * @author kaique
 *
 */
public interface VeiculoService {
	
	/**
	 * Retorna uma lista de peças
	 * @return
	 */
	List<Veiculo> getAll();
	
	/**
	 * Retorna uma Veiculo buscando pelo ID
	 * @param id
	 * @return
	 */
	Veiculo getById(Integer id);
	
	/**
	 * Retorna uma lista de Veiculos buscando pelo NOME
	 * @param name
	 * @return
	 */
	List<Veiculo> getByName(String name);
	
	/**
	 * Retorna um Veiculo buscando pelo NOME
	 * @return
	 */
	Veiculo getOneByName(String name);
	
	/**
	 * Salva um novo Veiculo
	 * @param Veiculo
	 */
	Integer save(Veiculo Veiculo);
	
	/**
	 * Insere uma lista de peças na tabela Veiculo_DEFEITOS
	 * @param list
	 */
	void insertPecas(List<PossivelDefeitoPeca> list, Integer idVeiculo);
	
}
