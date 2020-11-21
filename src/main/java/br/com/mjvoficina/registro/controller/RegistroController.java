package br.com.mjvoficina.registro.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.mjvoficina.possiveisDefeitosPecas.model.MappedPossivelDefeitoPeca;
import br.com.mjvoficina.possiveisDefeitosPecas.model.PossivelDefeitoPeca;
import br.com.mjvoficina.registro.model.MappedRegistro;
import br.com.mjvoficina.registro.service.RegistroService;
import br.com.mjvoficina.veiculo.model.Veiculo;
import br.com.mjvoficina.veiculo.service.VeiculoService;

/**
 * Controlador referente a rota /registrodefeitos
 * @author kaique
 *
 */
@Controller
@RequestMapping("/registrodefeitos")
public class RegistroController {

	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private RegistroService registroService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(RegistroController.class);
	
	/**
	 * Retorna uma tela para exibir os registros cadastrados
	 * @param model
	 * @return
	 */
	@GetMapping("/exibir")
	public String exibirRegistros(Model model) {
		LOGGER.info("Inicio exibirRegistros");
		
		List<Veiculo> list = veiculoService.getAll();
		model.addAttribute("veiculos", list);
		
		LOGGER.info("Fim exibirRegistros");
		return "exibirregistros";
	}
	
	/**
	 * Retorna uma resposta para o AJAX em /exibir/get
	 * Retorna uma lista com todos os registros no banco de dados
	 * @param name
	 * @param dataInicio
	 * @param dataFim
	 * @return
	 */
	@RequestMapping(value="/exibir/get", method=RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<Object> getAllRegistros(@RequestParam(required = false) String name,
												  @RequestParam(required = false) String dataInicio,
												  @RequestParam(required = false) String dataFim) {
		LOGGER.info("Inicio getAllRegistros");
		 
		Date dtInicio = null;
		Date dtFim = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy ss:mm:hh");
		
		try {
			if(!StringUtils.isEmpty(dataInicio)) {
				dtInicio = sdf.parse(dataInicio + " 00:00:00");
			}
			
			if(!StringUtils.isEmpty(dataFim)) {
				dtFim = sdf.parse(dataFim + " 00:00:59");
			}
		}catch(ParseException e) {
			LOGGER.error("A data foi informada fora do padrão.");
		}
 
		List<MappedRegistro> list = registroService.getAllRegistros(name, dtInicio, dtFim);
		LOGGER.info("Fim getAllRegistros");
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
	
	/**
	 * Cadastra um novo registro no banco de dados
	 * @param registros
	 * @param model
	 * @param name
	 * @return
	 */
	@PostMapping("/salvarregistro")
	public String postSalvarRegistro(@RequestParam(required = false) Integer[] registros, Model model, String name) {
		try {
			LOGGER.info("Inicio postSalvarRegistro");
			
			Veiculo veiculo = veiculoService.getOneByName(name);
			for(Integer i : registros) {
				PossivelDefeitoPeca pdp = registroService.getPossivelDefeitoPecaById(i);
				registroService.save(pdp, veiculo.getIdVeiculo()); 
			}
			model.addAttribute("link", "/registrodefeitos");
			model.addAttribute("titulo", "Registro salvo com sucesso!");
			
			LOGGER.info("Fim postSalvarRegistro");
			return "telasucesso";
		}catch (NullPointerException e) {
			LOGGER.error("Erro: " + e.getMessage());
			return "redirect:/registrodefeitos";
		}
	} 
	
	/**
	 * Retorna uma resposta ao AJAX em /getdefeitospecas
	 * Retorna uma lista de registros de defeitos em peças
	 * do tipo {@link PossivelDefeitoPeca}
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/getdefeitospecas", method=RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<Object> getPossiveisDefeitosByVeiculo(@RequestParam(required = false) String name) {
		LOGGER.info("Inicio getPossiveisDefeitosByVeiculo");

		if(StringUtils.isEmpty(name)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<MappedPossivelDefeitoPeca> possiveisDefeitos = registroService.selectAllDefeitoByPecasAndVeiculo(name);
		
		LOGGER.info("Fim getPossiveisDefeitosByVeiculo");
		return new ResponseEntity<Object>(possiveisDefeitos, HttpStatus.OK);
	}

	/**
	 * Retorna a tela de cadastro de registros
	 * @param model
	 * @return
	 */
	@GetMapping
	public String getNovoRegistros(Model model) {
		LOGGER.info("Inicio getNovoRegistros");
		List<Veiculo> tipoVeiculos = veiculoService.getAll();
		model.addAttribute("veiculos", tipoVeiculos);
		LOGGER.info("Fim getNovoRegistros");
		return "registrodefeitos";
	}
}
