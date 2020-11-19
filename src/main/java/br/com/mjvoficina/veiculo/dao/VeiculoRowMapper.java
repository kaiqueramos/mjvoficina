package br.com.mjvoficina.veiculo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.mjvoficina.veiculo.enums.TipoVeiculo;
import br.com.mjvoficina.veiculo.model.Veiculo;

public class VeiculoRowMapper implements RowMapper<Veiculo> {

	@Override
	public Veiculo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Veiculo veiculo = new Veiculo();
		veiculo.setTipoVeiculo(TipoVeiculo.valueOf(rs.getString("tipoVeiculo")));
		veiculo.setIdVeiculo(rs.getInt("idVeiculo"));
		return veiculo;
	}
}
