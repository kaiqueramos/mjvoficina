package br.com.mjvoficina.defeito.dao;

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

import br.com.mjvoficina.defeito.model.Defeito;

/**
 * Classe DAO referente a entidade DEFEITO
 * @author kaique
 *
 */
@Repository
public class DefeitoDaoImpl implements DefeitoDao {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private DataSource dataSource;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DefeitoDaoImpl.class);
	
	@Override
	@Transactional
	public List<Defeito> getAll() {
		String sql = "SELECT * FROM DEFEITOS";
		List<Defeito> list = new ArrayList<>();
		try {
			LOGGER.info("Inicio getAll");
			
			list.addAll(template.query(sql, new DefeitoRowMapper()));
			
			LOGGER.info("Fim getAll");
			return list;
		}catch(EmptyResultDataAccessException e) {
			LOGGER.error("Erro getAll: " + e.getMessage());
			return list;
		}
	}

	@Override
	@Transactional
	public Defeito getById(Integer id) {
		LOGGER.info("Inicio getById");
		String sql = "SELECT * FROM DEFEITOS WHERE IDDEFEITO = :idDefeito";
		MapSqlParameterSource param = new MapSqlParameterSource()
				.addValue("idDefeito", id);
		Defeito defeito = template.queryForObject(sql, param, new DefeitoRowMapper());
		LOGGER.info("Fim getById");
		return defeito;
	}

	@Override
	@Transactional
	public List<Defeito> getByName(String name) {
		String sql = "SELECT * FROM DEFEITOS WHERE nomeDefeito = :nomeDefeito";
		List<Defeito> list = new ArrayList<>();
		try {
			LOGGER.info("Inicio getByName");

			MapSqlParameterSource params = new MapSqlParameterSource()
					.addValue("nomeDefeito", name);
			list.addAll(template.query(sql, params, new DefeitoRowMapper()));
			
			LOGGER.info("Fim getByName");
			return list;
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error("Erro getByName: " + e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public void save(Defeito defeito) {
		LOGGER.info("Inicio save");
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
				.withTableName("DEFEITOS")
				.usingColumns("nomeDefeito");
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("nomeDefeito", defeito.getNomeDefeito());
		
		insert.execute(params);
		LOGGER.info("Fim save");
	}

	@Override
	@Transactional
	public Defeito getOneByName(String name) {
		String sql = "SELECT * FROM DEFEITOS WHERE nomeDefeito like :nomeDefeito";
		try {
			LOGGER.info("Inicio getOneByName");

			MapSqlParameterSource params = new MapSqlParameterSource()
					.addValue("nomeDefeito", name);
			Defeito defeito = template.queryForObject(sql, params, new DefeitoRowMapper());
			
			LOGGER.info("Fim getOneByName");
			return defeito;
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error("Erro getOneByName: " + e.getMessage());
			return null;
		}
	}
}
