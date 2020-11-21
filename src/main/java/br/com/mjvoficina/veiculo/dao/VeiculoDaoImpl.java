package br.com.mjvoficina.veiculo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.mjvoficina.possiveisDefeitosPecas.model.PossivelDefeitoPeca;
import br.com.mjvoficina.possiveisPecasVeiculos.model.PossiveisPecasVeiculoRowMapper;
import br.com.mjvoficina.possiveisPecasVeiculos.model.PossivelPecaVeiculo;
import br.com.mjvoficina.veiculo.model.Veiculo;

/**
 * Classe DAO referente a entidade Veiculo
 * @author kaique
 *
 */
@Repository	
public class VeiculoDaoImpl implements VeiculoDao {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private DataSource dataSource;
	
	private final Logger LOGGER = LoggerFactory.getLogger(VeiculoDaoImpl.class);
	
	@Override
	@Transactional
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
	@Transactional
	public Veiculo getById(Integer id) {
		try {
			LOGGER.info("Inicio getById");
			String sql = "SELECT * FROM VEICULOS WHERE idVeiculo = :idVeiculo";
			MapSqlParameterSource param = new MapSqlParameterSource()
					.addValue("idVeiculo", id);
			LOGGER.info("Fim getById");
			return template.queryForObject(sql, param, new VeiculoRowMapper());
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error("Erro: " + e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public List<Veiculo> getByName(String name) {
		String sql = "SELECT * FROM VEICULOS WHERE tipoVeiculo = :tipoVeiculo";
		List<Veiculo> list = new ArrayList<>();
		try {
			LOGGER.info("Inicio getByName");

			MapSqlParameterSource params = new MapSqlParameterSource()
					.addValue("tipoVeiculo", name);
			
			list.addAll(template.query(sql, params, new VeiculoRowMapper()));
			
			LOGGER.info("Fim getByName");
			return list;
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error("Erro: " + e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public Veiculo getOneByName(String name) {
		try {
			LOGGER.info("Inicio getOneByName");
			String sql = "SELECT * FROM VEICULOS WHERE tipoVeiculo = :tipoVeiculo";
			MapSqlParameterSource param = new MapSqlParameterSource()
					.addValue("tipoVeiculo", name);
			Veiculo veiculo = template.queryForObject(sql, param, new VeiculoRowMapper());
			LOGGER.info("Fim getOneByName");
			return veiculo;
		}catch(EmptyResultDataAccessException e) {
			LOGGER.error("Erro: " + e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public Integer save(Veiculo veiculo) {
		LOGGER.info("Inicio save");
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
				.withTableName("VEICULOS")
				.usingColumns("tipoVeiculo")
				.usingGeneratedKeyColumns("idVeiculo");
		
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("tipoVeiculo", veiculo.getTipoVeiculo());
		
		Integer key = (Integer) insert.executeAndReturnKey(params);
		
		LOGGER.info("Fim save");
		return key;
	}

	@Override
	@Transactional
	public void insertPecas(List<PossivelDefeitoPeca> list, Integer idVeiculo) {
		LOGGER.info("Inicio insertPeca");
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
				.withTableName("POSSIVEIS_PECAS_VEICULO")
				.usingColumns("fkIdPossivelDefeitoPeca", "fkIdVeiculo");
		
		
		for(PossivelDefeitoPeca p : list) {
			MapSqlParameterSource param = new MapSqlParameterSource()
					.addValue("fkIdPossivelDefeitoPeca", p.getIdPossivelDefeitoPeca())
					.addValue("fkIdVeiculo", idVeiculo);
			insert.execute(param);
		}
		
		LOGGER.info("Fim insertPeca");
		
	}

	@Override
	@Transactional
	public List<PossivelPecaVeiculo> selectAllPecasByVeiculo(String name) {
		try {
			LOGGER.info("Inicio selectAllPecasByVeiculo");
			
			Veiculo veiculo = getOneByName(name);
			String sql = "SELECT * FROM POSSIVEIS_PECAS_VEICULO WHERE fkIdVeiculo = :fkIdVeiculo";
			MapSqlParameterSource param = new MapSqlParameterSource()
					.addValue("fkIdVeiculo", veiculo.getIdVeiculo());
			List<PossivelPecaVeiculo> list = template.query(sql, param, new PossiveisPecasVeiculoRowMapper());
			
			LOGGER.info("Fim selectAllPecasByVeiculo");
			return list;
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error("Erro: " + e.getMessage());
			return null;
		}
	}
}
