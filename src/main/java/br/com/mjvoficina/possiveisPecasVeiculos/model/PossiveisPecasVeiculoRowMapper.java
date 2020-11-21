package br.com.mjvoficina.possiveisPecasVeiculos.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * RowMapper referente a tabela POSSIVEIS_PECAS_VEICULO
 * @author kaique
 *
 */
public class PossiveisPecasVeiculoRowMapper implements RowMapper<PossivelPecaVeiculo>{

	@Override
	public PossivelPecaVeiculo mapRow(ResultSet rs, int rowNum) throws SQLException {
		PossivelPecaVeiculo ppv = new PossivelPecaVeiculo();
		ppv.setIdPossivelDefeitoPeca(rs.getInt("fkIdPossivelDefeitoPeca"));
		ppv.setIdPossivelPecaVeiculo(rs.getInt("idPossivelPecaVeiculo"));
		ppv.setIdVeiculo(rs.getInt("fkIdVeiculo"));
		return ppv;
	}
	
	
}
