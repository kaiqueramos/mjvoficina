package br.com.mjvoficina.home.controller;

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

import br.com.mjvoficina.defeito.model.Defeito;
import br.com.mjvoficina.defeito.service.DefeitoService;
import br.com.mjvoficina.peca.dao.PecaDao;
import br.com.mjvoficina.peca.model.Peca;
import br.com.mjvoficina.peca.service.PecaService;
import br.com.mjvoficina.veiculo.enums.TipoVeiculo;
import br.com.mjvoficina.veiculo.model.Veiculo;
import br.com.mjvoficina.veiculo.service.VeiculoService;

@Controller
@RequestMapping("/")
public class HomeController {
	 
	@Autowired
	private PecaDao teste;
	
	@Autowired
	private DefeitoService defeitoService;
	
	@Autowired
	private PecaService pecaService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping
	public String home() {
		return "home";
	}
		
	@PostMapping("registrodefeitos/registrar")
	public String postRegistroDefeitos() {
		return "telasucesso";
	}
	
	@PostMapping("registrodefeitos/salvarregistro")
	public String postSalvarRegistro() {
		return "exibirregistros";
	}
	
	@RequestMapping(value="registrodefeitos/getdefeitospecas", method=RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<Object> getDefeitosPecasByVeiculo(@RequestParam(required = false) String name) {
		LOGGER.info("Inicio getDefeitosPecasByVeiculo");
		
		List<Peca> list = veiculoService.selectAllPecasByVeiculo(name);
		
		if(StringUtils.isEmpty(name)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Object>(list, HttpStatus.OK);
		
		/*if(list.isEmpty()) {
			LOGGER.info("Fim getDefeitosPecasByVeiculo");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			LOGGER.info("Fim getDefeitosPecasByVeiculo");
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		}*/
	}
	
	@GetMapping("registrodefeitos")
	public String getExibirRegistros(Model model) {
		List<TipoVeiculo> tipoVeiculos = Arrays.asList(TipoVeiculo.values());
		System.out.println(tipoVeiculos);
		model.addAttribute("veiculos", tipoVeiculos);		
		return "registrodefeitos";
	}
	
	@GetMapping("cadastrarveiculos")
	public String getCadastroVeiculos(Model model) {
		LOGGER.info("Inicio getCadastroVeiculos");
		
		List<Peca> list = pecaService.getAll();
		model.addAttribute("pecas", list);
		
		
		LOGGER.info("Fim getCadastroVeiculos");
		return "cadastroveiculos";
	}	
	
	@RequestMapping(value="cadastrarveiculos/getveiculo", method=RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
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
	
	@PostMapping("cadastrarveiculos/cadastrar")
	public String postCadastroVeiculos(@RequestParam("peca") String[] pecas,
										@RequestParam("nomeVeiculo") String nomeVeiculo,
										Model model) {
		
		LOGGER.info("Inicio postCadastroVeiculo");
		
		if(StringUtils.isEmpty(nomeVeiculo)) {
			return "redirect:/cadastrarveiculos/cadastrar";
		}
		
		List<String> list = Arrays.asList(pecas);
		List<Peca> listPecas = new ArrayList<>();
		Veiculo veiculo = new Veiculo();
		veiculo.setNomeVeiculo(nomeVeiculo);
		Integer idVeiculo = veiculoService.save(veiculo);
		
		for(String i : list) {
			Peca p = pecaService.getOneByName(i);
			listPecas.add(p);
		}
		
		veiculoService.insertPecas(listPecas, idVeiculo);
		
		model.addAttribute("link", "/cadastrarveiculos");
		model.addAttribute("titulo", "Veiculo cadastrado com sucesso!");
		
		LOGGER.info("Fim postCadastroVeiculo");
		return "telasucesso"; 
	}
	
	@GetMapping("cadastrarpecas")
	public String getCadastroPecas(Model model) {
		LOGGER.info("Inicio getCadastroPecas");
		
		List<Defeito> list = defeitoService.getAll();
		model.addAttribute("defeitos", list);
		
		LOGGER.info("Fim getCadastroPecas");
		return "cadastropecas";
	}
	
	@RequestMapping(value="cadastrarpecas/getpeca", method=RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<Object> getPecas(@RequestParam(required = false) String name) {
		LOGGER.info("Inicio getPecas");
		
		List<Peca> list = pecaService.getByName(name);
		
		if(StringUtils.isEmpty(name)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		  
		if(list.isEmpty()) {
			LOGGER.info("Fim getPecas");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			LOGGER.info("Fim getPecas");
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		}
	}
	
	@PostMapping("cadastrarpecas/cadastrar")
	public String postCadastroPecas(@RequestParam("defeito") String[] defeitos,
									@RequestParam("nomePeca") String nomePeca,
									Model model) {
		
		LOGGER.info("Inicio postCadastroPeca");
		
		if(StringUtils.isEmpty(nomePeca)) {
			return "redirect:/cadastrarpecas/cadastrar";
		}
		
		List<String> list = Arrays.asList(defeitos);
		List<Defeito> listDefeitos = new ArrayList<>();
		Peca peca = new Peca();
		peca.setNomePeca(nomePeca);
		Integer idPeca = pecaService.save(peca);
		
		for(String i : list) {
			Defeito d = defeitoService.getOneByName(i);
			listDefeitos.add(d);
		}
		
		pecaService.insertDefeitos(listDefeitos, idPeca);
		
		model.addAttribute("link", "/cadastrarpecas");
		model.addAttribute("titulo", "Peça cadastrada com sucesso!");
		
		LOGGER.info("Fim postCadastroPeca");
		return "telasucesso"; 
	}
	
	@GetMapping("cadastrardefeitos")
	public String getCadastroDefeitos() {
		return "cadastrodefeitos";
	}
	
	@PostMapping("cadastrardefeitos/cadastrar")
	public String postCadastroDefeitos(String nomeDefeito, Model model) {
		LOGGER.info("Inicio postCadastroDefeitos");
		
		if(StringUtils.isEmpty(nomeDefeito)) {
			return "redirect:/cadastrardefeitos";
		}
		
		Defeito defeito = new Defeito();
		defeito.setNomeDefeito(nomeDefeito);
		defeitoService.save(defeito);
		model.addAttribute("link", "/cadastrardefeitos");
		model.addAttribute("titulo", "Defeito cadastrado com sucesso!");
		
		LOGGER.info("Fim postCadastroDefeitos");
		return "telasucesso";
	}
	
	@RequestMapping(value="cadastrardefeitos/getdefeito", method=RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody 
	public ResponseEntity<Object> getDefeitos(@RequestParam(required = false) String name) {
		LOGGER.info("Inicio getDefeitos");
		
		List<Defeito> list = defeitoService.getByName(name);
		
		if(StringUtils.isEmpty(name)) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		 
		if(list.isEmpty()) {
			LOGGER.info("Fim getDefeitos");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			LOGGER.info("Fim getDefeitos");
			return new ResponseEntity<Object>(list, HttpStatus.OK);
		}
	}
}
