package br.com.mjvoficina.defeito.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import br.com.mjvoficina.defeito.model.Defeito;
import br.com.mjvoficina.defeito.service.DefeitoService;

/**
 * RowMapper referente a entidade DEFEITO
 * @author kaique
 *
 */
public class DefeitoRowMapper implements RowMapper<Defeito> {
	
	@Override
	public Defeito mapRow(ResultSet rs, int rowNum) throws SQLException {
		Defeito defeito = new Defeito();
		defeito.setNomeDefeito(rs.getString("nomeDefeito"));
		defeito.setIdDefeito(rs.getInt("idDefeito"));
		return defeito;
	}
}
