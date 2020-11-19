package br.com.mjvoficina.peca.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import br.com.mjvoficina.defeito.model.Defeito;
import br.com.mjvoficina.defeito.service.DefeitoService;
import br.com.mjvoficina.peca.model.Peca;
import br.com.mjvoficina.peca.service.PecaService;

public class PecaRowMapper implements RowMapper<Peca> {

	@Autowired
	private PecaService pecaService;
	
	@Autowired
	private DefeitoService defeitoService;
	
	@Override
	public Peca mapRow(ResultSet rs, int rowNum) throws SQLException {
		Peca peca = new Peca();
		peca.setNomePeca(rs.getString("nomePeca"));
		peca.setIdPeca(rs.getInt("idPeca"));
		return peca;
	}
	
	public class PecaFkIdRowMapper implements RowMapper<Peca>{

		@Override
		public Peca mapRow(ResultSet rs, int rowNum) throws SQLException {
			
		}
	}
}
