package br.com.mjvoficina.registro.dao;

import java.util.Date;
import java.util.List;

import br.com.mjvoficina.possiveisDefeitosPecas.model.PossivelDefeitoPeca;
import br.com.mjvoficina.possiveisPecasVeiculos.model.PossivelPecaVeiculo;
import br.com.mjvoficina.registro.model.Registro;

public interface RegistroDao {
	
	/**
	 * Seleciona um registro da tabela de possiveis peças de um veículo
	 * @param id
	 * @return
	 */
	PossivelPecaVeiculo getById(Integer id);
	
	/**
	 * Salva uma peca como possivel peça de um veículo
	 * @param registro
	 * @param idVeiculo
	 */
	void save(PossivelDefeitoPeca registro, Integer idVeiculo);

	/**
	 * Seleciona todos os registros da tabela REGISTROS
	 * @param name
	 * @param dtInicio
	 * @param dtFim
	 * @return
	 */
	List<Registro> getAllRegistros(String name, Date dtInicio, Date dtFim);
	
	/**
	 * Seleciona todos os possiveis defeitos de todas as possiveis peças
	 * de um veículo
	 * @param name
	 * @return
	 */
	List<PossivelDefeitoPeca> selectAllDefeitoByPecasAndVeiculo(String name);

	/**
	 * Seleciona um possivel defeito de um peça pelo id
	 * @param id
	 */
	PossivelDefeitoPeca getPossivelDefeitoPecaById(Integer id);

	/**
	 * Seleciona todos os possiveis defeitos por peça
	 * @param idPeca
	 * @return
	 */
	List<PossivelDefeitoPeca> getAllPossiveisDefeitosByPeca(Integer idPeca);
}
