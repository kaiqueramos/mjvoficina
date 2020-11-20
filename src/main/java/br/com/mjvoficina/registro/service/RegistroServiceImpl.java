package br.com.mjvoficina.registro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mjvoficina.defeito.model.Defeito;
import br.com.mjvoficina.defeito.service.DefeitoService;
import br.com.mjvoficina.peca.model.Peca;
import br.com.mjvoficina.peca.service.PecaService;
import br.com.mjvoficina.registro.dao.RegistroDao;
import br.com.mjvoficina.registro.model.MappedRegistro;
import br.com.mjvoficina.registro.model.Registro;
import br.com.mjvoficina.veiculo.model.Veiculo;
import br.com.mjvoficina.veiculo.service.VeiculoService;

@Service
public class RegistroServiceImpl implements RegistroService {

	@Autowired
	private RegistroDao registroDao;
	
	@Autowired
	private DefeitoService defeitoService;
	
	@Autowired
	private PecaService pecaService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Override
	public Registro getById(Integer id) {
		return registroDao.getById(id);
	}

	@Override
	public void save(Registro registro) {
		registroDao.save(registro);
	}

	@Override
	public List<MappedRegistro> getAllRegistros(String name, Date dtInicio, Date dtFim) {
		List<Registro> registros = registroDao.getAllRegistros(name, dtInicio, dtFim);
		List<MappedRegistro> registrosMapeados = new ArrayList<>();
		
		for(Registro r : registros) {
			Defeito d = defeitoService.getById(r.getIdDefeito());
			Peca p = pecaService.getById(r.getIdPeca());
			Veiculo v = veiculoService.getById(r.getIdVeiculo());
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
