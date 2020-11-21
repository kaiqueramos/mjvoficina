package br.com.mjvoficina.defeito.controller;

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
import br.com.mjvoficina.peca.service.PecaService;
import br.com.mjvoficina.registro.service.RegistroService;
import br.com.mjvoficina.veiculo.service.VeiculoService;

@Controller
@RequestMapping("/cadastrardefeitos")
public class DefeitoController {

	@Autowired
	private DefeitoService defeitoService;
	
	@Autowired
	private PecaService pecaService;
	
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private RegistroService registroService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(DefeitoController.class);
	
	@GetMapping
	public String getCadastroDefeitos() {
		return "cadastrodefeitos";
	}
	
	@PostMapping("/cadastrar")
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
	
	@RequestMapping(value="/getdefeito", method=RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
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
