package br.com.mjvoficina.registro.dao;

import java.util.Date;
import java.util.List;

import br.com.mjvoficina.registro.model.MappedRegistro;
import br.com.mjvoficina.registro.model.Registro;

public interface RegistroDao {
	
	Registro getById(Integer id);

	void save(Registro registro);

	List<Registro> getAllRegistros(String name, Date dtInicio, Date dtFim);
}
