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

import br.com.mjvoficina.defeito.model.Defeito;
import br.com.mjvoficina.peca.model.Peca;
import br.com.mjvoficina.veiculo.model.Veiculo;

@Repository
public class VeiculoDaoImpl implements VeiculoDao {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private DataSource dataSource;
	
	private final Logger LOGGER = LoggerFactory.getLogger(VeiculoDaoImpl.class);
	
	@Override
	public List<Veiculo> getAll() {
		String sql = "SELECT * FROM VeiculoS";
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
		String sql = "SELECT * FROM VeiculoS WHERE nomeVeiculo like :nomeVeiculo";
		List<Veiculo> list = new ArrayList<>();
		try {
			LOGGER.info("Inicio getByName");

			MapSqlParameterSource params = new MapSqlParameterSource()
					.addValue("nomeVeiculo", "%" + name + "%");
			
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer save(Veiculo Veiculo) {
		LOGGER.info("Inicio save");
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
				.withTableName("VeiculoS")
				.usingColumns("nomeVeiculo")
				.usingGeneratedKeyColumns("idVeiculo");
		
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("nomeVeiculo", Veiculo.getNomeVeiculo());
		
		Integer key = (Integer) insert.executeAndReturnKey(params);
		
		LOGGER.info("Fim save");
		return key;
	}

	@Override
	public void insertPeca(List<Peca> list, Integer idVeiculo) {
		LOGGER.info("Inicio insertDefeitos");
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
				.withTableName("Veiculo_DEFEITOS")
				.usingColumns("fkIdDefeito", "fkIdVeiculo");
		
		
		for(Peca p : list) {
			MapSqlParameterSource param = new MapSqlParameterSource()
					.addValue("fkIdDefeito", p.getIdPeca())
					.addValue("fkIdVeiculo", idVeiculo);
			insert.execute(param);
		}
		
		LOGGER.info("Fim insertDefeitos");
	}

}
