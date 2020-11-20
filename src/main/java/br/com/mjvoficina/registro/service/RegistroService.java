package br.com.mjvoficina.registro.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.mjvoficina.registro.dao.RegistroDao;
import br.com.mjvoficina.registro.model.MappedRegistro;
import br.com.mjvoficina.registro.model.Registro;

public interface RegistroService {
		
	Registro getById(Integer id);
	
	void save(Registro registro);

	List<MappedRegistro> getAllRegistros(String name, Date dtInicio, Date dtFim);
}
