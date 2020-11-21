package br.com.mjvoficina.registro.service;

import java.util.Date;
import java.util.List;

import br.com.mjvoficina.possiveisDefeitosPecas.model.MappedPossivelDefeitoPeca;
import br.com.mjvoficina.possiveisDefeitosPecas.model.PossivelDefeitoPeca;
import br.com.mjvoficina.possiveisPecasVeiculos.model.PossivelPecaVeiculo;
import br.com.mjvoficina.registro.model.MappedRegistro;
import br.com.mjvoficina.registro.model.Registro;

public interface RegistroService {
	
	/**
	 * Retorna um objeto do tipo PossivelPecaVeiculo buscando pelo ID
	 * @param id
	 * @return
	 */
	PossivelPecaVeiculo getById(Integer id);
	
	/**
	 * Salva um PossivelDefeitoPeca na tabela POSSIVEIS_DEFEITOS_PECA
	 * @param pdp
	 * @param idVeiculo
	 */
	void save(PossivelDefeitoPeca pdp, Integer idVeiculo);

	/**
	 * Retorna todos os registros da tabela REGISTROS já mapeados
	 * @param name
	 * @param dtInicio
	 * @param dtFim
	 * @return
	 */
	List<MappedRegistro> getAllRegistros(String name, Date dtInicio, Date dtFim);

	/**
	 * Retorna um PossivelDefeitoPeca buscando pelo ID
	 * @param id
	 * @return
	 */
	PossivelDefeitoPeca getPossivelDefeitoPecaById(Integer id);
	
	/**
	 * Retorna todos os registros da tabela POSSIVEIS_DEFEITOS_PECA compativeis com
	 * o id da peca buscada
	 * @param idPeca
	 * @return
	 */
	List<PossivelDefeitoPeca> getAllPossiveisDefeitosByPeca(Integer idPeca);
	
	/**
	 * Retorna uma lista de registros que contem um possivel defeito em uma possivel 
	 * peça de um veículo
	 * @param name
	 * @return
	 */
	List<MappedPossivelDefeitoPeca> selectAllDefeitoByPecasAndVeiculo(String name);
}
