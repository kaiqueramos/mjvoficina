package br.com.mjvoficina.registro.dao;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import br.com.mjvoficina.registro.model.MappedRegistro;
import br.com.mjvoficina.registro.model.Registro;
import br.com.mjvoficina.veiculo.model.Veiculo;
import br.com.mjvoficina.veiculo.service.VeiculoService;

@Repository
public class RegistroDaoImpl implements RegistroDao {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Override
	public Registro getById(Integer id) {
		String sql = "SELECT * FROM VEICULO_PECAS_DEFEITOS WHERE idRegistro = :idRegistro";
		MapSqlParameterSource param = new MapSqlParameterSource()
				.addValue("idRegistro", id);
		Registro registro = template.queryForObject(sql, param, new RegistroRowMapper());
		return registro;
	}

	@Override
	public void save(Registro registro) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(dataSource)
				.withTableName("REGISTROS")
				.usingColumns("fkIdVeiculo", "fkIdPeca", "fkIdDefeito");
		MapSqlParameterSource param = new MapSqlParameterSource()
				.addValue("fkIdVeiculo", registro.getIdVeiculo())
				.addValue("fkIdPeca", registro.getIdPeca())
				.addValue("fkIdDefeito", registro.getIdDefeito());
		
		insert.execute(param);
	}

	@Override
	public List<Registro> getAllRegistros(String name, Date dtInicio, Date dtFim) {
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
		return listRegistro;
	}

}
