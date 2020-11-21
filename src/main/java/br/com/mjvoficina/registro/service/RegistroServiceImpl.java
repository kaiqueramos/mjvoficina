package br.com.mjvoficina.registro.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mjvoficina.defeito.model.Defeito;
import br.com.mjvoficina.defeito.service.DefeitoService;
import br.com.mjvoficina.peca.model.Peca;
import br.com.mjvoficina.peca.service.PecaService;
import br.com.mjvoficina.possiveisDefeitosPecas.model.MappedPossivelDefeitoPeca;
import br.com.mjvoficina.possiveisDefeitosPecas.model.PossivelDefeitoPeca;
import br.com.mjvoficina.possiveisPecasVeiculos.model.PossivelPecaVeiculo;
import br.com.mjvoficina.registro.dao.RegistroDao;
import br.com.mjvoficina.registro.model.MappedRegistro;
import br.com.mjvoficina.registro.model.Registro;
import br.com.mjvoficina.veiculo.model.Veiculo;
import br.com.mjvoficina.veiculo.service.VeiculoService;

/**
 * Classe Service referente as entidades de registro
 * @author kaique
 *
 */
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
	@Transactional
	public PossivelPecaVeiculo getById(Integer id) {
		return registroDao.getById(id);
	}

	@Override
	@Transactional
	public void save(PossivelDefeitoPeca registro, Integer idVeiculo) {
		registroDao.save(registro, idVeiculo);
	}

	@Override
	@Transactional
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

	@Override
	@Transactional
	public List<MappedPossivelDefeitoPeca> selectAllDefeitoByPecasAndVeiculo(String name) {
		List<PossivelDefeitoPeca> listPdp = registroDao.selectAllDefeitoByPecasAndVeiculo(name);
		List<MappedPossivelDefeitoPeca> listMpdp = new ArrayList<>();
		
		for(PossivelDefeitoPeca pdp : listPdp) {
			Defeito d = defeitoService.getById(pdp.getIdDefeito());
			Peca p = pecaService.getById(pdp.getIdPeca());
			MappedPossivelDefeitoPeca m = new MappedPossivelDefeitoPeca();
			m.setIdPossivelDefeitoPeca(pdp.getIdPossivelDefeitoPeca());
			m.setPeca(p.getNomePeca());
			m.setDefeito(d.getNomeDefeito());
			listMpdp.add(m);
		}
		
		return listMpdp;
	}

	@Override
	@Transactional
	public PossivelDefeitoPeca getPossivelDefeitoPecaById(Integer id) {
		
		return registroDao.getPossivelDefeitoPecaById(id);
	}

	@Override
	@Transactional
	public List<PossivelDefeitoPeca> getAllPossiveisDefeitosByPeca(Integer idPeca) {
		return registroDao.getAllPossiveisDefeitosByPeca(idPeca);
	}
}
