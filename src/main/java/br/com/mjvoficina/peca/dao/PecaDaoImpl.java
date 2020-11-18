package br.com.mjvoficina.peca.dao;

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

import br.com.mjvoficina.defeito.dao.DefeitoRowMapper;
import br.com.mjvoficina.defeito.model.Defeito;
import br.com.mjvoficina.peca.model.Peca;

@Repository
public class PecaDaoImpl implements PecaDao {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private DataSource dataSource;
	
	private final Logger LOGGER = LoggerFactory.getLogger(PecaDaoImpl.class);
	
	@Override
	public List<Peca> getAll() {
		String sql = "SELECT * FROM PECAS";
		List<Peca> list = new ArrayList<>();
		try {
			LOGGER.info("Inicio getAll");
			list.addAll(template.query(sql, new PecaRowMapper()));
			LOGGER.info("Fim getAll");
			return list;
		}catch(EmptyResultDataAccessException e) {
			LOGGER.error("Erro: " + e.getMessage());
			return list;
		}
	}

	@Override
	public Peca getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Peca> getByName(String name) {
		String sql = "SELECT * FROM PECAS WHERE nomePeca like :nomePeca";
		List<Peca> list = new ArrayList<>();
		try {
			LOGGER.info("Inicio getByName");

			MapSqlParameterSource params = new MapSqlParameterSource()
					.addValue("nomePeca", "%" + name + "%");
			
			list.addAll(template.query(sql, params, new PecaRowMapper()));
			
			LOGGER.info("Fim getByName");
			return list;
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error("Erro getByName: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Peca getOneByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer save(Peca peca) {
		LOGGER.info("Inicio save");
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
				.withTableName("PECAS")
				.usingColumns("nomePeca")
				.usingGeneratedKeyColumns("idPeca");
		
		MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("nomePeca", peca.getNomePeca());
		
		Integer key = (Integer) insert.executeAndReturnKey(params);
		
		LOGGER.info("Fim save");
		return key;
	}

	@Override
	public void insertDefeitos(List<Defeito> list, Integer idPeca) {
		LOGGER.info("Inicio insertDefeitos");
		
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
				.withTableName("PECA_DEFEITOS")
				.usingColumns("fkIdDefeito", "fkIdPeca");
		
		
		for(Defeito d : list) {
			MapSqlParameterSource param = new MapSqlParameterSource()
					.addValue("fkIdDefeito", d.getIdDefeito())
					.addValue("fkIdPeca", idPeca);
			insert.execute(param);
		}
		
		LOGGER.info("Fim insertDefeitos");
	}

}
