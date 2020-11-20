package br.com.mjvoficina.registro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import br.com.mjvoficina.defeito.model.Defeito;
import br.com.mjvoficina.defeito.service.DefeitoService;
import br.com.mjvoficina.peca.model.Peca;
import br.com.mjvoficina.peca.service.PecaService;
import br.com.mjvoficina.registro.model.Registro;
import br.com.mjvoficina.veiculo.model.Veiculo;
import br.com.mjvoficina.veiculo.service.VeiculoService;

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
