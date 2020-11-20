package br.com.mjvoficina.veiculo.dao;

import java.util.List;

import br.com.mjvoficina.peca.model.Peca;
import br.com.mjvoficina.registro.model.Registro;
import br.com.mjvoficina.veiculo.model.Veiculo;

public interface VeiculoDao {
	
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
	 * Insere uma lista de peças na tabela VEICULO_PECAS
	 * @param list
	 */
	void insertPecas(List<Peca> list, Integer idVeiculo);
	
	/**
	 * Retorna uma lista de peças que um veículo pode conter
	 * e dentro das peças, um lista de defeitos que essa peça
	 * pode ter.
	 * @param name
	 */
	List<Registro> selectAllPecasByVeiculo(String name);
}
