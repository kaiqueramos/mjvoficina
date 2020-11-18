package br.com.mjvoficina.peca.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.mjvoficina.peca.model.Peca;

public class PecaRowMapper implements RowMapper<Peca> {

	@Override
	public Peca mapRow(ResultSet rs, int rowNum) throws SQLException {
		Peca peca = new Peca();
		peca.setNomePeca(rs.getString("nomePeca"));
		peca.setIdPeca(rs.getInt("idPeca"));
		return peca;
	}
}
