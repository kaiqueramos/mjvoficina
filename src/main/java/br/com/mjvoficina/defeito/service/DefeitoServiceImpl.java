package br.com.mjvoficina.defeito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjvoficina.defeito.dao.DefeitoDao;
import br.com.mjvoficina.defeito.model.Defeito;

@Service
public class DefeitoServiceImpl implements DefeitoService {

	@Autowired
	private DefeitoDao defeitoDao;
	
	@Override
	public List<Defeito> getAll() {
		List<Defeito> list = defeitoDao.getAll();
		return list;
	}

	@Override
	public Defeito getById(Integer id) {
		
		return defeitoDao.getById(id);
	}

	@Override
	public List<Defeito> getByName(String name) {
		return defeitoDao.getByName(name);
	}

	@Override
	public void save(Defeito defeito) {
		defeitoDao.save(defeito);
	}

	@Override
	public Defeito getOneByName(String name) {
		
		return defeitoDao.getOneByName(name);
	}

}
