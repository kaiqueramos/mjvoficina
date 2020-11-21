package br.com.mjvoficina.registro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.mjvoficina.possiveisDefeitosPecas.model.PossivelDefeitoPeca;
import br.com.mjvoficina.possiveisDefeitosPecas.model.PossiveisDefeitosPecaRowMapper;
import br.com.mjvoficina.possiveisPecasVeiculos.model.PossiveisPecasVeiculoRowMapper;
import br.com.mjvoficina.possiveisPecasVeiculos.model.PossivelPecaVeiculo;
import br.com.mjvoficina.registro.controller.RegistroController;
import br.com.mjvoficina.registro.model.Registro;
import br.com.mjvoficina.veiculo.model.Veiculo;
import br.com.mjvoficina.veiculo.service.VeiculoService;

/**
 * Classe controller para as entidades referentes a registros
 * @author kaique
 *
 */
@Repository
public class RegistroDaoImpl implements RegistroDao {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private VeiculoService veiculoService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(RegistroController.class);
	
	@Override
	@Transactional
	public PossivelPecaVeiculo getById(Integer id) {
		try {
			LOGGER.info("Inicio getById");
			
			String sql = "SELECT * FROM POSSIVEIS_PECAS_VEICULO WHERE idPossivelPecaVeiculo = :idPossivelPecaVeiculo";
			MapSqlParameterSource param = new MapSqlParameterSource()
					.addValue("idPossivelPecaVeiculo", id);
			PossivelPecaVeiculo registro = template.queryForObject(sql, param, new PossiveisPecasVeiculoRowMapper());
			
			LOGGER.info("Fim getById");
			return registro;
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error("Erro: " + e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public void save(PossivelDefeitoPeca registro, Integer idVeiculo) {
		LOGGER.info("Inicio save");
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
				.withTableName("REGISTROS")
				.usingColumns("fkIdVeiculo", "fkIdPeca", "fkIdDefeito");
		MapSqlParameterSource param = new MapSqlParameterSource()
				.addValue("fkIdPeca", registro.getIdPeca())
				.addValue("fkIdDefeito", registro.getIdDefeito())
				.addValue("fkIdVeiculo", idVeiculo);
		
		insert.execute(param);
		LOGGER.info("Fim save");
	}

	@Override
	@Transactional
	public List<Registro> getAllRegistros(String name, Date dtInicio, Date dtFim) {
		try {
			LOGGER.info("Inicio getAllRegistros");
			StringBuilder sql = new StringBuilder("SELECT * FROM REGISTROS WHERE 1 = 1");
			MapSqlParameterSource param = new MapSqlParameterSource();
			
			if(!StringUtils.isEmpty(name)) {
				Veiculo veiculo = veiculoService.getOneByName(name);
				sql.append(" AND fkIdVeiculo = :fkIdVeiculo ");
				param.addValue("fkIdVeiculo", veiculo.getIdVeiculo());
			}
			
			if(dtInicio != null) {
				sql.append(" AND DATA >= :inicio ");
				param.addValue("inicio", dtInicio);
			}
			
			if(dtFim != null) {
				sql.append(" AND DATA <= :fim ");
				param.addValue("fim", dtFim);
			}
			
			sql.append(" ORDER BY DATA DESC");
			 
			List<Registro> listRegistro = template.query(sql.toString(), param, new RegistroRowMapper());
			
			LOGGER.info("Fim getAllRegistros");
			return listRegistro;
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error("Erro: " + e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public List<PossivelDefeitoPeca> selectAllDefeitoByPecasAndVeiculo(String name) {
		try {
			LOGGER.info("Inicio selectAllDefeitoByPecasAndVeiculo");
			String sqlTablePossiveisPecasVeiculo = "SELECT * FROM POSSIVEIS_PECAS_VEICULO WHERE fkIdVeiculo = :fkIdVeiculo";
			Veiculo veiculo = veiculoService.getOneByName(name);
			MapSqlParameterSource param = new MapSqlParameterSource()
					.addValue("fkIdVeiculo", veiculo.getIdVeiculo());
			List<Integer> listIdPossiveisDefeitosPeca = template.query(sqlTablePossiveisPecasVeiculo, param, new RowMapper<Integer>() {
				@Override
				public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
					Integer id = rs.getInt("fkIdPossivelDefeitoPeca");
					return id;
				}
			});
			
			if(listIdPossiveisDefeitosPeca.isEmpty()) {
				return null;
			}
			
			List<PossivelDefeitoPeca> pdp = new ArrayList<>();
			String sql = "SELECT * FROM POSSIVEIS_DEFEITOS_PECA WHERE idPossivelDefeitoPeca = :idPossivelDefeitoPeca";
	
			for(Integer i : listIdPossiveisDefeitosPeca) {
				MapSqlParameterSource p = new MapSqlParameterSource()
						.addValue("idPossivelDefeitoPeca", i);
				pdp.addAll(template.query(sql, p, new PossiveisDefeitosPecaRowMapper()));
			}
			
			LOGGER.info("Fim selectAllDefeitoByPecasAndVeiculo");
			return pdp;
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error("Erro: " + e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public PossivelDefeitoPeca getPossivelDefeitoPecaById(Integer id) {
		try {
			LOGGER.info("Inicio getPossivelDefeitoPecaById");
			
			String sql = "SELECT * FROM POSSIVEIS_DEFEITOS_PECA WHERE idPossivelDefeitoPeca = :idPossivelDefeitoPeca";
			MapSqlParameterSource param = new MapSqlParameterSource()
					.addValue("idPossivelDefeitoPeca", id);
			PossivelDefeitoPeca pdp = template.queryForObject(sql, param, new PossiveisDefeitosPecaRowMapper());
			
			LOGGER.info("Inicio getPossivelDefeitoPecaById");
			return pdp;
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error("Erro: " + e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public List<PossivelDefeitoPeca> getAllPossiveisDefeitosByPeca(Integer idPeca) {
		try {
			LOGGER.info("Inicio getAllPossiveisDefeitosByPeca");
			
			String sql = "SELECT * FROM POSSIVEIS_DEFEITOS_PECA WHERE fkIdPeca = :fkIdPeca";
			MapSqlParameterSource param = new MapSqlParameterSource()
					.addValue("fkIdPeca", idPeca);
			List<PossivelDefeitoPeca> list = template.query(sql, param, new PossiveisDefeitosPecaRowMapper());
			
			LOGGER.info("Fim getAllPossiveisDefeitosByPeca");
			return list;
		}catch (EmptyResultDataAccessException e) {
			LOGGER.error("Erro: " + e.getMessage());
			return null;
		}
	}
}
