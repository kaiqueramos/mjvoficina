package br.com.mjvoficina.veiculo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjvoficina.peca.model.Peca;
import br.com.mjvoficina.veiculo.dao.VeiculoDao;
import br.com.mjvoficina.veiculo.model.Veiculo;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private VeiculoDao veiculoDao;
	
	@Override
	public List<Veiculo> getAll() {
		return veiculoDao.getAll();
	}

	@Override
	public Veiculo getById(Integer id) {
		return veiculoDao.getById(id);
	}

	@Override
	public List<Veiculo> getByName(String name) {
		return veiculoDao.getByName(name);
	}

	@Override
	public Veiculo getOneByName(String name) {
		return veiculoDao.getOneByName(name);
	}

	@Override
	public Integer save(Veiculo Veiculo) {
		Integer key = veiculoDao.save(Veiculo);
		return key;
	}

	@Override
	public void insertPecas(List<Peca> list, Integer idVeiculo) {
		veiculoDao.insertPecas(list, idVeiculo);
	}

	@Override
	public List<Peca> selectAllPecasByVeiculo(String name) {
		return veiculoDao.selectAllPecasByVeiculo(name);
	}

}
