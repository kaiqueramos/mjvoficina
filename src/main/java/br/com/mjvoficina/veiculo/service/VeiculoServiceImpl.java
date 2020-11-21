package br.com.mjvoficina.veiculo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mjvoficina.possiveisDefeitosPecas.model.PossivelDefeitoPeca;
import br.com.mjvoficina.veiculo.dao.VeiculoDao;
import br.com.mjvoficina.veiculo.model.Veiculo;

/**
 * Classe Service referente a entidade VEICULO
 * @author kaique
 *
 */
@Service
public class VeiculoServiceImpl implements VeiculoService {
	
	@Autowired
	private VeiculoDao veiculoDao;
	
	@Override
	@Transactional
	public List<Veiculo> getAll() {
		return veiculoDao.getAll();
	}

	@Override
	@Transactional
	public Veiculo getById(Integer id) {
		return veiculoDao.getById(id);
	}

	@Override
	@Transactional
	public List<Veiculo> getByName(String name) {
		return veiculoDao.getByName(name);
	}

	@Override
	@Transactional
	public Veiculo getOneByName(String name) {
		return veiculoDao.getOneByName(name);
	}

	@Override
	@Transactional
	public Integer save(Veiculo Veiculo) {
		Integer key = veiculoDao.save(Veiculo);
		return key;
	}

	@Override
	@Transactional
	public void insertPecas(List<PossivelDefeitoPeca> list, Integer idVeiculo) {
		veiculoDao.insertPecas(list, idVeiculo);
	}

}
