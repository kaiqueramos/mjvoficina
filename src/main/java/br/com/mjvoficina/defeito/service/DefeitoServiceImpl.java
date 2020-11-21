package br.com.mjvoficina.defeito.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mjvoficina.defeito.dao.DefeitoDao;
import br.com.mjvoficina.defeito.model.Defeito;

/**
 * Classe Service referente a entidade DEFEITO
 * @author kaique
 *
 */
@Service
public class DefeitoServiceImpl implements DefeitoService {

	@Autowired
	private DefeitoDao defeitoDao;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DefeitoServiceImpl.class);
	
	@Override
	@Transactional
	public List<Defeito> getAll() {
		LOGGER.info("Inicio getAll");
		List<Defeito> list = defeitoDao.getAll();
		LOGGER.info("Fim getAll");
		return list;
	}

	@Override
	@Transactional
	public Defeito getById(Integer id) {
		LOGGER.info("Inicio getById");
		LOGGER.info("Fim getById");
		return defeitoDao.getById(id);
	}

	@Override
	@Transactional
	public List<Defeito> getByName(String name) {
		LOGGER.info("Inicio getByName");
		LOGGER.info("Fim getByName");
		return defeitoDao.getByName(name);
	}

	@Override
	@Transactional
	public void save(Defeito defeito) {
		LOGGER.info("Inicio save");
		LOGGER.info("Fim save");
		defeitoDao.save(defeito);
	}

	@Override
	@Transactional
	public Defeito getOneByName(String name) {
		LOGGER.info("Inicio getOneByName");
		LOGGER.info("Fim getOneByName");
		return defeitoDao.getOneByName(name);
	}
}
