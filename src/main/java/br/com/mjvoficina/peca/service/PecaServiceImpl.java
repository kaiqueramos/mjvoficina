package br.com.mjvoficina.peca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mjvoficina.defeito.model.Defeito;
import br.com.mjvoficina.peca.dao.PecaDao;
import br.com.mjvoficina.peca.model.Peca;

/**
 * Classe Service referente a entidade PECA
 * @author kaique
 *
 */
@Service
public class PecaServiceImpl implements PecaService {

	@Autowired
	private PecaDao pecaDao;
	
	@Override
	@Transactional
	public List<Peca> getAll() {
		return pecaDao.getAll();
	}

	@Override
	@Transactional
	public Peca getById(Integer id) {
		return pecaDao.getById(id);
	}

	@Override
	@Transactional
	public List<Peca> getByName(String name) {
		return pecaDao.getByName(name);
	}

	@Override
	@Transactional
	public Peca getOneByName(String name) {
		return pecaDao.getOneByName(name);
	}

	@Override
	@Transactional
	public Integer save(Peca peca) {
		Integer key = pecaDao.save(peca);
		return key;
	}

	@Override
	@Transactional
	public void insertDefeitos(List<Defeito> list, Integer idPeca) {
		pecaDao.insertDefeitos(list, idPeca);
	}

	@Override
	@Transactional
	public Peca selectAllDefeitosByPeca(Integer idPeca) {
		return pecaDao.selectAllDefeitosByPeca(idPeca);
	}

}
