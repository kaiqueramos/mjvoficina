package br.com.mjvoficina.veiculo.controller;

import java.util.ArrayList;
import java.util.Arrays;
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

import br.com.mjvoficina.peca.model.Peca;
import br.com.mjvoficina.peca.service.PecaService;
import br.com.mjvoficina.possiveisDefeitosPecas.model.PossivelDefeitoPeca;
import br.com.mjvoficina.registro.service.RegistroService;
import br.com.mjvoficina.veiculo.model.Veiculo;
import br.com.mjvoficina.veiculo.service.VeiculoService;

/**
 * Classe controller referente a rota /cadastrarveiculos
 * @author kaique
 *
 */
@Controller
@RequestMapping("/cadastrarveiculos")
public class VeiculoController {
	
	@Autowired
	private PecaService pecaService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private RegistroService registroService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(VeiculoController.class);
	
	/**
	 * Retorna uma tela para cadastro de veículos
	 * @param model
	 * @return
	 */
	@GetMapping
	public String getCadastroVeiculos(Model model) {
		LOGGER.info("Inicio getCadastroVeiculos");
		
		List<Peca> list = pecaService.getAll();
		model.addAttribute("pecas", list);
		
		
		LOGGER.info("Fim getCadastroVeiculos");
		return "cadastroveiculos";
	}	
	
	/**
	 * Retorna uma resposta ao AJAX em /getveiculo
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/getveiculo", method=RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<Object> getVeiculo(@RequestParam(required = false) String name) {
		LOGGER.info("Inicio getVeiculo");
		
		List<Veiculo> list = veiculoService.getByName(name);
		
		if(StringUtils.isEmpty(name)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		  
		if(list.isEmpty()) {
			LOGGER.info("Fim getVeiculo");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			LOGGER.info("Fim getVeiculo");
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		}
	}
	
	/**
	 * Cadastra um novo veículo
	 * @param pecas
	 * @param nomeVeiculo
	 * @param model
	 * @return
	 */
	@PostMapping("/cadastrar")
	public String postCadastroVeiculos(@RequestParam("peca") String[] pecas,
										@RequestParam("nomeVeiculo") String nomeVeiculo,
										Model model) {
		
		LOGGER.info("Inicio postCadastroVeiculo");
		
		if(StringUtils.isEmpty(nomeVeiculo)) {
			return "redirect:/cadastrarveiculos/cadastrar";
		}
		
		List<String> list = Arrays.asList(pecas);
		List<PossivelDefeitoPeca> listPecas = new ArrayList<>();
		Veiculo veiculo = new Veiculo();
		veiculo.setTipoVeiculo(nomeVeiculo);
		Integer idVeiculo = veiculoService.save(veiculo);
		
		
		for(String i : list) {
			Peca p = pecaService.getOneByName(i);
			List<PossivelDefeitoPeca> pdp = registroService.getAllPossiveisDefeitosByPeca(p.getIdPeca());
			listPecas.addAll(pdp);
		}
		
		veiculoService.insertPecas(listPecas, idVeiculo);
		
		model.addAttribute("link", "/cadastrarveiculos");
		model.addAttribute("titulo", "Veiculo cadastrado com sucesso!");
		
		LOGGER.info("Fim postCadastroVeiculo");
		return "telasucesso"; 
	}
}
