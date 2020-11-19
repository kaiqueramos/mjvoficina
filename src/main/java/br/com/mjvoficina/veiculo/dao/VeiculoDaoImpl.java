package br.com.mjvoficina.veiculo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.mjvoficina.defeito.model.Defeito;
import br.com.mjvoficina.defeito.service.DefeitoService;
import br.com.mjvoficina.peca.model.Peca;
import br.com.mjvoficina.peca.service.PecaService;
import br.com.mjvoficina.veiculo.enums.TipoVeiculo;
import br.com.mjvoficina.veiculo.model.Veiculo;

@Repository
public class VeiculoDaoImpl implements VeiculoDao {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private PecaService pecaService;
	
	@Autowired
	private DefeitoService defeitoService;
	
	@Autowired
	private DataSource dataSource;
	
	private final Logger LOGGER = LoggerFactory.getLogger(VeiculoDaoImpl.class);
	
	@Override
	public List<Veiculo> getAll() {
		String sql = "SELECT * FROM VEICULOS";
		List<Veiculo> list = new ArrayList<>();
		try {
			LOGGER.info("Inicio getAll");
			list.addAll(template.query(sql, new VeiculoRowMapper()));
			LOGGER.info("Fim getAll");
			return list;
		}catch(EmptyResultDataAccessException e) {
			LOGGER.error("Erro: " + e.getMessage());
			return list;
		}
	}

	@Override
	public Veiculo getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Veiculo> getByName(String name) {
		String sql = "SELECT * FROM VeiculoS WHERE tipoVeiculo like :tipoVeiculo";
		List<Veiculo> list = new ArrayList<>();
		try {
			LOGGER.info("Inicio getByName");

			MapSqlParameterSource params = new MapSqlParameterSource()
					.addValue("tipoVeiculo", "%" + name + "%");
			
			list.addAll(template.query(sql, params, new VeiculoRowMapper()));
			
			LOGGER.info("Fim getByName");
			return list;
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error("Erro getByName: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Veiculo getOneByName(String name) {
		String sql = "SELECT * FROM VEICULOS WHERE tipoVeiculo = :tipoVeiculo";
		MapSqlParameterSource param = new MapSqlParameterSource()
				.addValue("tipoVeiculo", name);
		Veiculo veiculo = template.queryForObject(sql, param, new VeiculoRowMapper());
		return veiculo;
	}

	@Override
	public Integer save(Veiculo Veiculo) {
		LOGGER.info("Inicio save");
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
				.withTableName("VEICULOS")
				.usingColumns("nomeVeiculo", "tipoVeiculo")
				.usingGeneratedKeyColumns("idVeiculo");
		
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("nomeVeiculo", Veiculo.getNomeVeiculo())
				.addValue("tipoVeiculo", TipoVeiculo.CARRO);
		
		Integer key = (Integer) insert.executeAndReturnKey(params);
		
		LOGGER.info("Fim save");
		return key;
	}

	@Override
	public void insertPecas(List<Peca> list, Integer idVeiculo) {
		LOGGER.info("Inicio insertPeca");
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
				.withTableName("VEICULO_PECAS")
				.usingColumns("fkIdPeca", "fkIdVeiculo");
		
		
		for(Peca p : list) {
			MapSqlParameterSource param = new MapSqlParameterSource()
					.addValue("fkIdPeca", p.getIdPeca())
					.addValue("fkIdVeiculo", idVeiculo);
			insert.execute(param);
		}
		
		LOGGER.info("Fim insertPeca");
	}

	@Override
	public List<Peca> selectAllPecasByVeiculo(String name) {
		String sql = "SELECT vpd.DATA, v.IDVEICULO, v.TIPOVEICULO, p.IDPECA, p.NOMEPECA, d.IDDEFEITO, d.NOMEDEFEITO FROM VEICULO_PECAS_DEFEITOS vpd, VEICULOS v, PECAS p, DEFEITOS d WHERE fkIdVeiculo = idVeiculo AND fkIdPeca = idPeca AND fkIdDefeito = idDefeito AND fkIdVeiculo = :idVeiculo";
		
	}
}
