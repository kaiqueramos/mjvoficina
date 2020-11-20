package br.com.mjvoficina.veiculo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjvoficina.defeito.model.Defeito;
import br.com.mjvoficina.defeito.service.DefeitoService;
import br.com.mjvoficina.peca.model.Peca;
import br.com.mjvoficina.peca.service.PecaService;
import br.com.mjvoficina.registro.model.MappedRegistro;
import br.com.mjvoficina.registro.model.Registro;
import br.com.mjvoficina.veiculo.dao.VeiculoDao;
import br.com.mjvoficina.veiculo.model.Veiculo;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
	private DefeitoService defeitoService;
	
	@Autowired
	private PecaService pecaService;
	
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
	public List<MappedRegistro> selectAllPecasByVeiculo(String name) {
		List<MappedRegistro> registrosMapeados = new ArrayList<>();
		List<Registro> registros = veiculoDao.selectAllPecasByVeiculo(name);
		
		for(Registro r : registros) {
			Defeito d = defeitoService.getById(r.getIdDefeito());
			Peca p = pecaService.getById(r.getIdPeca());
			Veiculo v = getById(r.getIdVeiculo());
			MappedRegistro mr = new MappedRegistro();
			mr.setDefeito(d);
			mr.setPeca(p);
			mr.setVeiculo(v);
			mr.setDataRegistro(r.getDataRegistro());
			mr.setIdRegistro(r.getIdRegistro());
			registrosMapeados.add(mr);
		}
		return registrosMapeados;
	}

}
