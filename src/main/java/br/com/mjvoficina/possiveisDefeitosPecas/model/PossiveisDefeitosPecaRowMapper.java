package br.com.mjvoficina.possiveisDefeitosPecas.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * RowMapper referente a tabela POSSIVEIS_DEFEITOS_PECA
 * @author kaique
 *
 */
public class PossiveisDefeitosPecaRowMapper implements RowMapper<PossivelDefeitoPeca> {

	@Override
	public PossivelDefeitoPeca mapRow(ResultSet rs, int rowNum) throws SQLException {
		PossivelDefeitoPeca pdp = new PossivelDefeitoPeca();
		pdp.setIdPossivelDefeitoPeca(rs.getInt("idPossivelDefeitoPeca"));
		pdp.setIdPeca(rs.getInt("fkIdPeca"));
		pdp.setIdDefeito(rs.getInt("fkIdDefeito"));
		return pdp;
	}
	
}
