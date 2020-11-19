package br.com.mjvoficina.peca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjvoficina.defeito.model.Defeito;
import br.com.mjvoficina.peca.dao.PecaDao;
import br.com.mjvoficina.peca.model.Peca;

@Service
public class PecaServiceImpl implements PecaService {

	@Autowired
	private PecaDao pecaDao;
	
	@Override
	public List<Peca> getAll() {
		
		return pecaDao.getAll();
	}

	@Override
	public Peca getById(Integer id) {
		return pecaDao.getById(id);
	}

	@Override
	public List<Peca> getByName(String name) {
		return pecaDao.getByName(name);
	}

	@Override
	public Peca getOneByName(String name) {
		return pecaDao.getOneByName(name);
	}

	@Override
	public Integer save(Peca peca) {
		Integer key = pecaDao.save(peca);
		return key;
	}

	@Override
	public void insertDefeitos(List<Defeito> list, Integer idPeca) {
		pecaDao.insertDefeitos(list, idPeca);
	}

	@Override
	public Peca selectAllDefeitosByPeca(Integer idPeca) {
		return pecaDao.selectAllDefeitosByPeca(idPeca);
	}

}
