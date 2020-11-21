package br.com.mjvoficina.peca.controller;

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
import br.com.mjvoficina.peca.model.Peca;
import br.com.mjvoficina.peca.service.PecaService;
import br.com.mjvoficina.registro.service.RegistroService;
import br.com.mjvoficina.veiculo.service.VeiculoService;

/**
 * Controlador para a rota /cadastrarpecas
 * @author kaique
 *
 */
@Controller
@RequestMapping("/cadastrarpecas")
public class PecaController {

	@Autowired
	private DefeitoService defeitoService;
	
	@Autowired
	private PecaService pecaService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(PecaController.class);
	
	/**
	 * Retorna a tela de cadastro de peças
	 * @param model
	 * @return
	 */
	@GetMapping
	public String getCadastroPecas(Model model) {
		LOGGER.info("Inicio getCadastroPecas");
		
		List<Defeito> list = defeitoService.getAll();
		model.addAttribute("defeitos", list);
		
		LOGGER.info("Fim getCadastroPecas");
		return "cadastropecas";
	}
	
	/**
	 * Retorna uma resposta para o AJAX /getpeca
	 * @param name
	 * @return
	 */
	@RequestMapping(value="/getpeca", method=RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
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
	
	/**
	 * Realiza o cadastro de uma peça
	 * @param defeitos
	 * @param nomePeca
	 * @param model
	 * @return
	 */
	@PostMapping("/cadastrar")
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
	
}
