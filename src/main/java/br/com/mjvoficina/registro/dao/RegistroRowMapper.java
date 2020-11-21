package br.com.mjvoficina.registro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.mjvoficina.registro.model.Registro;

/**
 * RowMapper referente a tabela REGISTROS
 * @author kaique
 *
 */
public class RegistroRowMapper implements RowMapper<Registro> {
	
	@Override
	public Registro mapRow(ResultSet rs, int rowNum) throws SQLException {
		Registro registro = new Registro();
		registro.setIdDefeito(rs.getInt("fkIdDefeito"));
		registro.setIdPeca(rs.getInt("fkIdPeca"));	
		registro.setIdVeiculo(rs.getInt("fkIdVeiculo"));
		registro.setDataRegistro(rs.getDate("data"));
		registro.setIdRegistro(rs.getInt("idRegistro"));
		return registro;
	}
	
}
